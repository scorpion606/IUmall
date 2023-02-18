package com.scorpion.service.timerjob;

import com.github.wxpay.sdk.WXPay;
import com.scorpion.entity.OrderItem;
import com.scorpion.entity.Orders;
import com.scorpion.entity.ProductSku;
import com.scorpion.mapper.OrderItemMapper;
import com.scorpion.mapper.OrdersMapper;
import com.scorpion.mapper.ProductSkuMapper;
import com.scorpion.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scorpion
 * @date 2022/2/14
 */
@Component
public class OrderCheckTimeJob {
    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private OrderService orderService;
    private WXPay wxPay = new WXPay(new MyPayConfig());

    /**
     * 实现超时取消订单功能
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void orderCheckTime() {
        try {
        //1，每隔5秒查询一次订单状态是否为未支付且创建订单时间大于一天
        Example example=new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");
        Date time=new Date(System.currentTimeMillis()-24*60*60*1000);
        criteria.andLessThan("createdTime",time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        //2，访问微信支付平台，确认该订单确实已经支付成功
            // （补偿机制防止微信支付回调接口出现异常导致用户已经支付成功，但是订单状态修改为超时取消）
            for (int i = 0; i < orders.size(); i++) {
                Orders order = orders.get(i);
                HashMap<String, String> data = new HashMap<>();
                data.put("out_trade_no", order.getOrderId());
                Map<String, String> response = wxPay.orderQuery(data);


                //2.1，如果订单支付成功，则修改订单状态为已支付(序号2)
                if("SUCCESS".equalsIgnoreCase(response.get("trade_state"))){
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");
                    updateOrder.setCancelType(0);
                    ordersMapper.updateByPrimaryKeySelective(updateOrder);
                    System.out.println(1);
                }else if("NOTPAY".equalsIgnoreCase(response.get("trade_state"))){
                    //2.2如果订单未支付，则关闭支付链接，防止出现用户在订单关闭之后却支付了
                    Map<String, String> Map = wxPay.closeOrder(data);

                    //关闭超时订单
                    orderService.closeOrder(order.getOrderId());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
