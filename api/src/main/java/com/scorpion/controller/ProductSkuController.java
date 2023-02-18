package com.scorpion.controller;

import com.scorpion.service.ProductSkuService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/4/19
 */
@RestController
@CrossOrigin
@Api(tags = "商品套餐管理",value = "提供商品套餐相关业务接口")
@RequestMapping("/sku")
public class ProductSkuController {
    @Resource
    private ProductSkuService productSkuService;

    @ApiOperation(value="查找套餐信息和销售属性接口")
    @GetMapping("/getSkuToAttr/{skuId}")
    public ResultVo getSkuToAttr(@PathVariable("skuId") int skuId) {
        ResultVo resultVo = productSkuService.listSkuToAttrBySkuId(skuId);
        return resultVo;
    }
}
