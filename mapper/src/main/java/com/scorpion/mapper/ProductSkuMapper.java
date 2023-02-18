package com.scorpion.mapper;

import com.scorpion.entity.ProductSku;
import com.scorpion.entity.ProductSkuVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface ProductSkuMapper extends BaseMapper<ProductSku> {
    /**
     * 查询当前商品中套餐最低价格的商品
     * @param ProductId 商品ID
     * @return 如果查找成功以ProductSku返回List集合
     */
    public List<ProductSku> selectProductSkuByProductId(int ProductId);

    /**
     * 查询当前商品的套餐列表
     * @param pId 商品ID
     * @return 如果查找成功以ProductSku返回List集合
     */
    public List<ProductSkuVo> selectProductSkuByPid(int pId);

    /**
     * 根据skuId查找套餐基本信息
     * @param skuId 套餐ID
     * @return 如果查找成功以ProductSku返回
     */
    public ProductSkuVo selectProductSkuBySkuId(int skuId);
}