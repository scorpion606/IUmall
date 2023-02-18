package com.scorpion.mapper;

import com.scorpion.entity.OrderItem;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderItemMapper extends BaseMapper<OrderItem> {
    /**
     * 子查询订单快照
     * @param orderId 订单ID
     * @return 如果查找成功返回OrderItem对象形式返回List集合
     */
    public List<OrderItem> selectOrderItem(String orderId);

    /**
     * 通过订单ID修改逻辑删除状态
     * @param orderId 订单Id
     * @param deleted 逻辑删除状态
     * @return
     */
    public int updateOrderItemByItemId(@Param("orderId") String orderId,@Param("deleted") int deleted);
}