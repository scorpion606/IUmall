package com.scorpion.mapper;

import com.scorpion.entity.Orders;
import com.scorpion.entity.OrdersVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrdersMapper extends BaseMapper<Orders> {
    /**
     * 通过用户ID或者动态订单状态查询订单
     * @param userId 用户ID
     * @param status 订单状态
     * @return 如果查找成功以OrdersVo对象形式返回List集合
     */
    public List<OrdersVo> selectOrdersByUIdOrStatus(@Param("userId") int userId,@Param("status") String status,
                                                    @Param("start") int start,@Param("limit") int limit);

    public List<OrdersVo> selectOrderByoId(String orderId);
}