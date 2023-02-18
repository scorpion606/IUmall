package com.scorpion.mapper;

import com.scorpion.entity.ShoppingCart;
import com.scorpion.entity.ShoppingCartVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    /**
     * 实现根据用户ID查找购物车列表信息
     * @param userId 用户ID
     * @return 如果查找成功以ShoppingCartVo对象返回List集合
     */
    public List<ShoppingCartVo> selectShoppingCartByUserId(int userId);

    /**
     * 实现通过购物车ID修改商品套餐的数量
     * @param cartId 购物车ID
     * @param cartNumber 商品套餐数量
     * @return 如果修改成功返回大于0的整数，否则返回0
     */
    public int updateCartNumberByCartId(@Param("cartId") int cartId, @Param("cartNumber") int cartNumber);

    /**
     * 根据购物车ID集合查询购物车信息
     * @param cIds 购物车ID集合
     * @return 如果查找成功以ShoppingCartVo对象返回List集合
     */
    public List<ShoppingCartVo> selectShoppingCartByCartId(List<Integer> cIds);


}