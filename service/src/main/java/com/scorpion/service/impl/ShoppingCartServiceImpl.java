package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.ShoppingCart;
import com.scorpion.entity.ShoppingCartVo;
import com.scorpion.entity.Users;
import com.scorpion.mapper.ShoppingCartMapper;
import com.scorpion.service.ShoppingCartService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/29
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public ResultVo addShoppingCart(ShoppingCart cart,String token) {
        //  通过token从redis获取用户信息
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users users = objectMapper.readValue(userJson, Users.class);
            cart.setUserId(users.getUserId());
            System.out.println(users);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        //添加购物车时间
        cart.setCartTime(new Date());
        //查找购物车中的商品
        int i=0;
        Example example = new Example(ShoppingCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",cart.getUserId());
        criteria.andEqualTo("skuId",cart.getSkuId());
        List<ShoppingCart> shoppingCartVos = shoppingCartMapper.selectByExample(example);

        if (shoppingCartVos.size() > 0) {
        for(ShoppingCart s:shoppingCartVos) {

                if (s.getSkuId()!=cart.getSkuId()) { //如果购物车没有该商品，加入购物车
                    i = shoppingCartMapper.insert(cart);

                } else if (s.getSkuId()==cart.getSkuId()) { //如果购物车有该商品修改商品的套餐数量
                    int cartNumber = s.getCartNumber() + cart.getCartNumber();
                    shoppingCartMapper.updateCartNumberByCartId(s.getCartId(), cartNumber);
                    return new ResultVo(ResponseStatus.success, "success", null);
                }
            }
        }else {
            i = shoppingCartMapper.insert(cart);

        }
        if(i>0){
            return new ResultVo(ResponseStatus.success,"success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"fail",null);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVo listShoppingCart(String token) {
       ResultVo resultVo=null;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            List<ShoppingCartVo> shoppingCartVos = shoppingCartMapper.selectShoppingCartByUserId(user.getUserId());
            resultVo = new ResultVo(ResponseStatus.success, "success", shoppingCartVos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultVo;

    }

    @Override
    public ResultVo updateCartNumber(int cartId, int cartNumber) {
        int i = shoppingCartMapper.updateCartNumberByCartId(cartId, cartNumber);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }
    }

    @Override
    public ResultVo listChooseShoppingCart(String cIds) {
        /*处理从前端传入的购物车ID（类型为字符串）集合转换为List<Integer>*/
        String[] split = cIds.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i=0;i<split.length;i++){
            cartIds.add(Integer.parseInt(split[i]));
        }
        List<ShoppingCartVo> shoppingCartVos = shoppingCartMapper.selectShoppingCartByCartId(cartIds);
        return new ResultVo(ResponseStatus.success,"success",shoppingCartVos);
    }

    @Override
    public ResultVo deleteChooseShoppingCart(int cId) {
        Example example = new Example(ShoppingCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cartId",cId);
        int i = shoppingCartMapper.deleteByExample(example);
        if(i>0){
            return new ResultVo(ResponseStatus.success, "删除成功!", null);
        }else{
            return new ResultVo(ResponseStatus.fail, "删除失败!", null);
        }
    }

    @Override
    public ResultVo updateCartStatus(int cartId, Integer status) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(cartId);
        shoppingCart.setStatus(String.valueOf(status));
        int i = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }
    }

    @Override
    public ResultVo deleteChooseAll(List<Integer> cIds) {
        Example example = new Example(ShoppingCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("cartId", cIds);
        int i = shoppingCartMapper.deleteByExample(example);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"delete success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"delete fail",null);
        }
    }
}
