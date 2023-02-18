package com.scorpion.service;

import com.scorpion.entity.ShoppingCart;
import com.scorpion.vo.ResultVo;

import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/29
 */
public interface ShoppingCartService {
    /**
     * 实现添加购物车功能，调用tkMapper中的insert方法
     * @param cart 购物车对象
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo addShoppingCart(ShoppingCart cart,String token);

    /**
     * 实现通过用户ID查找购物车列表功能，调用mapper层的selectShoppingCartByUserId接口
     * @param token 用户令牌
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listShoppingCart(String token);

    /**
     * 通过购物车ID修改商品套餐数量
     * @param cartId 购物车ID
     * @param cartNumber 商品套餐数量
     * @return 返回ResultVo对象
     */
    public ResultVo updateCartNumber(int cartId,int cartNumber);

    /**
     * 根据购物车ID集合查找选择的商品信息
     * @param cIds 购物车ID集合
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listChooseShoppingCart(String cIds);

    /**
     * 根据购物车ID删除选中的商品信息
     * @param cId 购物车ID
     * @return 如果删除成功返回ResultVo对象
     */
    public ResultVo deleteChooseShoppingCart(int cId);

    /**
     * 根据购物车ID修改购物车商品的勾选状态
     * @param cartId 购物车Id
     * @param status 购物车状态
     * @return 如果修改成功返回ResultVo对象
     */
    public ResultVo updateCartStatus(int cartId,Integer status);

    /**
     * 删除选中的全部商品
     * @param cIds 购物车集合ID
     * @return 如果删除成功返回ResultVo集合
     */
    public ResultVo deleteChooseAll(List<Integer> cIds);
}
