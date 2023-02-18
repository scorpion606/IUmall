package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/4/19
 */
public interface ProductSkuService {
    /**
     * 根据skuID查找套餐信息和属性信息
     * @param skuId 套餐Id
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listSkuToAttrBySkuId(int skuId);
}
