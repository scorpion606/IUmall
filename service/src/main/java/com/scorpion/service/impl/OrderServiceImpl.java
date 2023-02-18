package com.scorpion.service.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.*;
import com.scorpion.mapper.OrderItemMapper;
import com.scorpion.mapper.OrdersMapper;
import com.scorpion.mapper.ProductSkuMapper;
import com.scorpion.mapper.ShoppingCartMapper;
import com.scorpion.service.OrderService;
import com.scorpion.vo.PageHelper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * @author scorpion
 * @date 2021/12/5
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrderItemMapper orderItemMapper;
    
    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Transactional
    public ResultVo addOrder(String cIds, Orders orders) throws SQLException {
        Map<String, String> map=new HashMap<String, String>();
        //将购物车ID由字符串转化为整数集合
        String[] split = cIds.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            cartIds.add(Integer.parseInt(split[i]));
        }
        //根据购物车ID查找购物车详情信息
        List<ShoppingCartVo> shoppingCartVos = shoppingCartMapper.selectShoppingCartByCartId(cartIds);
        //判断是否有库存
        boolean f = true;
        String productName="";
        for (int i = 0; i < cartIds.size(); i++) {
            //如果用户购买数量大于库存，退出循环
            if (shoppingCartVos.get(i).getCartNumber() > shoppingCartVos.get(i).getStock()) {
                f = false;
            }
            if(i<cartIds.size()-1){
                productName+=shoppingCartVos.get(i).getProductName()+",";
            }else{
                productName+=shoppingCartVos.get(i).getProductName();
            }
        }
        if (f) {
            //库存充足
            //生成OrderId
            String orderId = UUID.randomUUID().toString().replace("-","");
            //设置商品名称
            orders.setProductName(productName);
            //设置订单ID
            orders.setOrderId(orderId);
            //设置订单初始状态
            orders.setStatus("1");
            //设置逻辑删除的状态，0：代表未删除，1代表已删除
            orders.setDeleteStatus(0);
            //设置订单生成时间
            orders.setCreatedTime(new Date());
            //保存订单
            int insert = ordersMapper.insert(orders);
            if(insert>0){
                //保存订单成功
                  //1,保存订单快照
                List<OrderItem> list=new ArrayList<>();
                for (ShoppingCartVo sc:shoppingCartVos) {
                    OrderItem orderItem = new OrderItem(orderId, sc.getProductId(), sc.getProductName(),
                            sc.getSkuImg(), sc.getSkuId(), sc.getSkuName(), new BigDecimal(sc.getSellPrice()),
                            sc.getCartNumber(), new BigDecimal(sc.getSellPrice() * sc.getCartNumber()),
                            sc.getCreatedTime(), new Date(), 0,sc.getSkuProps(),0);
                    list.add(orderItem);

                }
                  //2,调用tkMapper中的insertList方法
                int oi = orderItemMapper.insertList(list);
                  //3，根据skuId修改库存
                for (ShoppingCartVo sc:shoppingCartVos) {
                    int skuId = sc.getSkuId();
                    int newStock=sc.getStock()-sc.getCartNumber();
                    //通过tkMapper修改库存数量
                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    int ps = productSkuMapper.updateByPrimaryKeySelective(productSku);
                }
                //删除购物车记录：当订单提交成功，删除购物车的选择记录
                for(int cId : cartIds){
                    shoppingCartMapper.deleteByPrimaryKey(cId);
                }
                map.put("orderId",orderId);
                return new ResultVo(ResponseStatus.success,"保存订单成功!",map);
            }else{
                //保存订单失败
                return new ResultVo(ResponseStatus.fail,"保存订单失败!",null);
            }
        } else {
            //库存不足
            return new ResultVo(ResponseStatus.STOCK_LESS, "库存不足，提交订单失败!", null);
        }

    }

    @Override
    @Transactional
    public ResultVo saveOrder(Orders order, int skuId, int buyCount) {
        /**
         * 1、通过套餐ID查找该套餐库存信息，比较用户购买数量和库存
         * 2、如果库存充足
         *  2.1、保存订单
         *  2.2、保存订单快照
         *  2.3、修改套餐库存
         * 3、如果库存不足，返回库存不足信息
         */
        ResultVo resultVo=null;
        ProductSkuVo sku = productSkuMapper.selectProductSkuBySkuId(skuId);
        Boolean f=true;
        if(sku.getStock()<buyCount){
            f=false;
        }
        if(f){
            //  库存充足
            //  生成订单ID
            String orderId = UUID.randomUUID().toString().replace("-", "");
            order.setOrderId(orderId);
            //  设置订单名称
            order.setProductName(sku.getSkuName());
            //  设置订单初始状态
            order.setStatus("1");
            //  设置逻辑删除的状态，0：代表未删除，1代表已删除
            order.setDeleteStatus(0);
            //  设置订单生成时间
            order.setCreatedTime(new Date());
            int insert = ordersMapper.insert(order);
            // 如果保存订单成功，保存订单快照
            if(insert>0){
                String skuAttr="";
                for (PmsSkuSaleAttrValue item:sku.getPmsSkuSaleAttrValue()) {
                    skuAttr+=item.getAttrValue();
                }
                OrderItem orderItem = OrderItem.builder()
                        .orderId(orderId)
                        .productId(sku.getProductId())
                        .productName(sku.getSkuName())
                        .productImg(sku.getSkuImg())
                        .skuId(skuId)
                        .skuName(sku.getSkuName())
                        .skuAttr(skuAttr)
                        .productPrice(sku.getSellPrice())
                        .buyCount(buyCount)
                        .totalAccount(order.getActualAccount())
                        .isCommont(0)
                        .deleted(0)
                        .build();
                int i = orderItemMapper.insert(orderItem);
                // 如果订单快照保存成功，修改套餐库存
                if(i>0){
                    int newStock=sku.getStock()-buyCount;
                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    int update = productSkuMapper.updateByPrimaryKeySelective(productSku);
                    if(update>0){
                        Map<String,Object> map=new HashMap<>();
                        map.put("orderId",orderId);
                        resultVo=new ResultVo(ResponseStatus.success,"保存订单成功",map);
                    }else{
                        resultVo=new ResultVo(ResponseStatus.fail,"保存订单失败",null);
                    }
                }
            }

        }else{
            //  库存不足
            resultVo= new ResultVo(ResponseStatus.STOCK_LESS, "库存不足，提交订单失败!", null);
        }
        return resultVo;
    }

    @Override
    public int updateOrderStatus(String orderId, String status) {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setStatus(status);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        return i;
    }

    @Override
    public ResultVo ListOrderStatus(String orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        return new ResultVo(ResponseStatus.success,"success",orders.getStatus());
    }

    //该注解作用表示事务串行化，防止多个用户同时取消订单，还原库存
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void closeOrder(String orderId) {
        //添加jvm串行化，将并发的事务串行化（一个一个执行）
        synchronized (this) {
            //2.2a修改当前订单：修改订单表中的status为已关闭(序号5),订单关闭类型为超时未支付（序号1）
            Orders cancelOrder = new Orders();
            cancelOrder.setOrderId(orderId);
            cancelOrder.setStatus("5");
            cancelOrder.setCancelType(1);
            ordersMapper.updateByPrimaryKeySelective(cancelOrder);
            //2.2b还原库存：先根据订单ID查找商品快照-(sku_id,buy_count)，修改sku表中的库存
            Example example1 = new Example(OrderItem.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("orderId", orderId);
            List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
            for (int j = 0; j < orderItems.size(); j++) {
                OrderItem orderItem = orderItems.get(j);
                ProductSku productSku = productSkuMapper.selectByPrimaryKey(orderItem.getSkuId());
                productSku.setStock(orderItem.getBuyCount() + productSku.getStock());
                productSkuMapper.updateByPrimaryKey(productSku);
            }
        }
    }

    @Override
    public ResultVo listOrders(String token, String status,int pageNum,int limit) {
        ResultVo resultVo=null;
        String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
        try {
            Users user = objectMapper.readValue(userJson, Users.class);
            Integer userId = user.getUserId();
            //查询订单总数
            Example example = new Example(Orders.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId",userId);
            if(status!=null&&!"".equals(status)){
                criteria.andEqualTo("status",status);
            }
            //订单总记录数
            int count = ordersMapper.selectCountByExample(example);
            //总页数
            int pageCount=count%limit==0?count/limit:count/limit+1;
            //分页开始索引
            int start =(pageNum-1)*limit;
            //通过用户ID和订单状态分页查询订单列表
            List<OrdersVo> list = ordersMapper.selectOrdersByUIdOrStatus(userId, status, start, limit);
            resultVo=new ResultVo(ResponseStatus.success,"success",new PageHelper<>(count,pageCount,list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultVo;
    }

    @Override
    public ResultVo listOrdersByOrderId(String orderId) {
        Map<String, Object> map=new HashMap<>();
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        List<Orders> orders = ordersMapper.selectByExample(example);
        if(orders.size()>0) {
            map.put("orderId",orders.get(0).getOrderId());
            map.put("productName",orders.get(0).getProductName());
            map.put("totalPrice",orders.get(0).getActualAccount());
            return new ResultVo(ResponseStatus.success, "list success", map);
        }else{
            return new ResultVo(ResponseStatus.fail,"list fail",null);
        }
    }

    @Override
    public ResultVo updatePayType(String orderId, int payType) {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setPayType(payType);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }

    }

    @Override
    public ResultVo deleteOrder(String orderId) {
        Orders order = Orders.builder()
                .orderId(orderId)
                .deleteStatus(1)
                .build();
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        int j = orderItemMapper.updateOrderItemByItemId(orderId, 1);
        if(i>0&&j>0){
            return new  ResultVo(ResponseStatus.success,"delete success",null);
        }else {
            return new ResultVo(ResponseStatus.fail, "delete fail", null);
        }
    }

    @Override
    public ResultVo listOrdersDetail(String oId) {
        List<OrdersVo> ordersVos = ordersMapper.selectOrderByoId(oId);
        if(ordersVos.size()>0) {
            return new ResultVo(ResponseStatus.success,"list success",ordersVos.get(0));
        }else{
            return new ResultVo(ResponseStatus.fail,"list fail",null);
        }

    }

    @Override
    public ResultVo listOrderStatusCount(String token) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if (userJson != null) {
            Users user = null;
            try {
                user = objectMapper.readValue(userJson, Users.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            Integer userId = user.getUserId();
            //  待支付
            Example example1 = new Example(Orders.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("userId", userId)
                    .andEqualTo("status", "1");

            int payment = ordersMapper.selectCountByExample(example1);

            //  待发货
            Example example2 = new Example(Orders.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("userId", userId)
                    .andEqualTo("status", "2")
                    .andEqualTo("deleteStatus", 0);
            int deliver = ordersMapper.selectCountByExample(example2);

            //  待收货
            Example example3 = new Example(Orders.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("userId", userId)
                    .andEqualTo("status", "3")
                    .andEqualTo("deleteStatus", 0);
            int receive = ordersMapper.selectCountByExample(example3);

            //  待评价
            Example example4 = new Example(Orders.class);
            Example.Criteria criteria4 = example4.createCriteria();
            criteria4.andEqualTo("userId", userId)
                    .andEqualTo("status", "4")
                    .andEqualTo("deleteStatus", 0);
            int evaluate = ordersMapper.selectCountByExample(example4);

            //  全部
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            Example example5 = new Example(Orders.class);
            Example.Criteria criteria5 = example5.createCriteria();
            criteria5.andEqualTo("userId", userId)
                    .andIn("status", list)
                    .andEqualTo("deleteStatus", 0);

            int all = ordersMapper.selectCountByExample(example5);

            Map<String, Integer> map = new HashMap<>();
            map.put("paymentCount", payment);
            map.put("deliverCount", deliver);
            map.put("receiveCount", receive);
            map.put("evaluateCount", evaluate);
            map.put("allCount", all);
            resultVo= new ResultVo(ResponseStatus.success, "list success", map);
        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }
        return resultVo;
    }
}
