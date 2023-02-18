package com.scorpion.controller;

import com.scorpion.service.ProductCommontsService;
import com.scorpion.service.ProductService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2021/11/16
 */
@RequestMapping(value = "/product")
@CrossOrigin
@Api(value="提供商品信息相关接口",tags = "商品管理")
@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private ProductCommontsService productCommontsService;

    /**
     * 实现查询商品详情信息
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value="商品基本信息查询接口")
    @GetMapping(value="/product-details/{pId}")
    public ResultVo getProductsDetails(@PathVariable(value="pId") int productId){
        return productService.listProductsDetails(productId);
    }

    /**
     * 实现查询参数信息
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value="商品参数信息查询接口")
    @GetMapping(value="/detail-params/{pId}")
    public ResultVo getProductParams(@PathVariable(value="pId") int productId){
        return productService.listProductPrams(productId);
    }

    /**
     * 实现查询参数信息
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value="商品评论信息查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "integer",name = "pageNum",value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "integer",name = "limit",value = "每页显示评论条数",required = true)
    })
    @GetMapping(value="/detail-commonts/{pId}")
    public ResultVo getProductCommonts(@PathVariable(value="pId") int productId,int pageNum,int limit){
        return productCommontsService.listProductCommonts(productId,pageNum,limit);
    }

    /**
     * 实现统计商品评价信息
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value = "商品评论统计接口")
    @GetMapping(value = "/detail-commentCount/{pId}")
    public ResultVo getProductCommentCount(@PathVariable(value="pId") int productId){
        return productCommontsService.listProductCount(productId);
    }

    /**
     * 实现查找三级分类商品并分页显示
     * @param categoryId 分类ID
     * @param pageNum 当前页码
     * @param limit 每页显示商品的个数
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value = "商品分类查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "integer",name = "pageNum",value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "integer",name = "limit",value = "每页显示商品数量",required = true)
    })
    @GetMapping(value = "/listCategoryProduct/{cId}")
    public ResultVo getCategoryProduct(@PathVariable(value="cId") int categoryId,int pageNum,int limit){
        ResultVo categoryProduct = productService.listCategoryProducts(categoryId, pageNum, limit);
        return categoryProduct;
    }
 

    /**
     * 实现根据三级分类ID查找商品品牌
     * @param categoryId 分类ID
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value = "商品分类品牌查询接口")
    @GetMapping(value = "/listBrandProduct/{cId}")
    public ResultVo getBrandProduct(@PathVariable(value="cId") int categoryId){
        ResultVo brands = productService.listBrandProducts(categoryId);
        return brands;
    }

    /**
     * 实现根据关键词查找商品并分页显示
     * @param keyWord 关键词
     * @param pageNum 当前页码
     * @param limit 每页显示商品数量
     * @return 如果查找成功以ResultVo对象返回
     */
    @ApiOperation(value = "关键字查询商品接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "keyWord",value="关键词",required = true),
            @ApiImplicitParam(dataType="Integer",name = "pageNum",value="当前页码",required = false),
            @ApiImplicitParam(dataType="Integer",name = "limit",value="每页显示商品数量",required = false)
    })
    @GetMapping(value = "/searchProduct")
    public ResultVo getProductByKeyWord(String keyWord,int pageNum,int limit){
        ResultVo products = productService.listProductByKeyWord(keyWord, pageNum, limit);
        return products;
    }

    @ApiOperation(value = "关键字查找品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name="keyWord",value = "关键词",required = true)
    })
    @GetMapping(value = "/searchBrands")
    public ResultVo getBrandByKeyWord(String keyWord){
        ResultVo brands = productService.listBrandByKeyWord(keyWord);
        return brands;
    }

    @ApiOperation(value = "输入关键词查找商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name="keyWord",value = "关键词",required = true)
    })
    @GetMapping(value = "/searchResult")
    public ResultVo getSearchResult(String keyWord){
        ResultVo resultVo = productService.listSearchResultByKeyWord(keyWord);
        return resultVo;
    }

    @ApiOperation(value = "输入关键词自动补全")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "prefix",value="搜索关键词",required = true),
            @ApiImplicitParam(dataType = "INTEGER",name = "limit",value = "推荐个数",required = true)
    })
    @GetMapping("/aotuCompletion")
    public ResultVo aotuCompletion(String prefix,int limit){
        ResultVo resultVo = productService.autoCompletion(prefix,limit);
        return resultVo;
    }

    @ApiOperation(value = "通过关键词或者分类ID查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "keyWord",value="关键词",required = false),
            @ApiImplicitParam(dataType = "Integer",name = "cId",value="分类ID",required = false),
            @ApiImplicitParam(dataType="Integer",name = "pageNum",value="当前页码",required = true),
            @ApiImplicitParam(dataType="Integer",name = "limit",value="每页显示商品数量",required = true)
    })
    @GetMapping(value = "productList")
    public ResultVo getProductListByKwOrCId(String keyWord,Integer cId,int pageNum,int limit){
        ResultVo resultVo = productService.listProductByCIdOrKeyWord(keyWord, cId, pageNum, limit);
        return  resultVo;
    }

}
