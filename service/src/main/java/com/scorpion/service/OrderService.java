package com.scorpion.service;

import com.scorpion.entity.Orders;
import com.scorpion.vo.ResultVo;

import java.sql.SQLException;

/**
 * @author scorpion
 * @date 2021/12/5
 */
public interface OrderService {

    /**
     * 实现保存订单功能，调用tkMapper中的updateByPrimaryKeySelective方法
     * @param cIds 选中的购物车ID
     * @param orders 订单信息
     * @return 如果保存成功返回ResultVo对象
     */
    public ResultVo addOrder(String cIds, Orders orders) throws SQLException;

    /**
     * 实现通过立即购买保存订单
     * @param order 订单对象
     * @param skuId 套餐Id
     * @param buyCount 购买数量
     * @return
     */
    public ResultVo saveOrder(Orders order,int skuId,int buyCount);

    /**
     * 实现通过订单号修改订单的状态，调用tkMapper中的update方法
     * @param orderId 订单ID
     * @param status 订单状态
     * @return 如果修改成功返回的整数大于0，否则修改失败返回的整数等于0
     */
    public int updateOrderStatus(String orderId,String status);

    /**
     * 实现通过订单ID查询订单状态，调用tkMapper中的方法
     * @param orderId 订单ID
     * @return 如果查找成功返回ResultVo
     */
    public ResultVo ListOrderStatus(String orderId);

    /**
     * 实现通过订单ID取消超时订单
     * @param orderId 订单ID
     */
    public void closeOrder(String orderId);

    /**
     * 实现通过用户ID和订单状态查询订单
     * @param token 用户令牌
     * @param status 订单状态
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listOrders(String token,String status,int pageNum,int limit);


    /**
     * 通过订单ID查找订单信息
     * @param orderId 订单ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listOrdersByOrderId(String orderId);

    /**
     * 通过订单ID修改订单支付状态
     * @param orderId 订单Id
     * @param payType 订单支付方式
     * @return 如果修改成功返回ResultVo对象
     */
    public ResultVo updatePayType(String orderId, int payType);

    /**
     * 通过订单Id删除已取消的订单
     * @param orderId 订单Id
     * @return 如果删除成功返回ResultVo对象
     */
    public ResultVo deleteOrder(String orderId);

    public ResultVo listOrdersDetail(String oId);

    /**
     * 查找userId不同订单的状态总数
     * @param token 用户令牌
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listOrderStatusCount(String token);
}
