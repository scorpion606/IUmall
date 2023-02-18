package com.scorpion.mapper;

import com.scorpion.entity.PmsSkuSaleAttrValue;
import com.scorpion.generator.BaseMapper;

import java.util.List;

public interface PmsSkuSaleAttrValueMapper extends BaseMapper<PmsSkuSaleAttrValue> {
    /**
     * 通过套餐ID查询商品的销售属性查询
     * @param skuId
     * @return
     */
    public List<PmsSkuSaleAttrValue> selectSkuSaleAttrValueBySkuId(List skuId);
}