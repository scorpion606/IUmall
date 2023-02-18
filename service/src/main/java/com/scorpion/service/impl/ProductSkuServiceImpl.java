package com.scorpion.service.impl;

import com.scorpion.entity.ProductSku;
import com.scorpion.entity.ProductSkuVo;
import com.scorpion.mapper.ProductSkuMapper;
import com.scorpion.service.ProductSkuService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/4/19
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {
    @Resource
    private ProductSkuMapper productSkuMapper;
    @Override
    public ResultVo listSkuToAttrBySkuId(int skuId) {
        ProductSkuVo productSkuVo = productSkuMapper.selectProductSkuBySkuId(skuId);
        if(productSkuVo!=null){
            return new ResultVo(ResponseStatus.success,"list success",productSkuVo);
        }else{
            return new ResultVo(ResponseStatus.fail,"list fail",null);
        }

    }
}
