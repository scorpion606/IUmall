package com.scorpion.controller;

import com.scorpion.service.*;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2021/11/6
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/index")
@Api(tags = "首页管理",value="提供首页业务相关接口")
public class IndexController {
    @Resource
    private IndexImgService indexImgService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductService ProductService;

    @Resource
    private IuAdService iuAdService;
    /**
     * 实现返回首页轮播图信息功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value = "首页轮播图接口")
    @GetMapping(value="/indexImg")
    public ResultVo getIndexImg(){
        return indexImgService.ListIndexImg();
    }

    /**
     * 实现返回商品分类信息功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value = "商品分类信息接口")
    @GetMapping(value = "/category")
    public ResultVo getCategory(){
        return categoryService.listCategory();
    }

    @ApiOperation(value="商品分类信息子查询接口")
    @GetMapping(value = "/getCategoryChildren")
    public ResultVo getCategoryChildren(){
        ResultVo resultVo = categoryService.listCategoryChildren();
        return resultVo;
    }

    /**
     * 实现商品推荐功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value = "商品推荐接口")
    @GetMapping(value = "/recommend-list")
    public ResultVo getRecommendProductions(){
        return ProductService.listRecommendProductions();
    }

    /**
     * 实现分类商品推荐功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value = "商品分类推荐接口")
    @GetMapping(value = "/categories-recommends")
    public ResultVo getFirstLevelRecommend(){
        return categoryService.listFirstLevelCategories();
    }



    /**
     * 实现查询广告图片功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value ="查询广告图片")
    @GetMapping(value = "/getAdvert")
    public ResultVo getAdvert(){
//        ResultVo resultVo = productImgService.listAdvertImg();
        ResultVo resultVo = iuAdService.getAd();
        return resultVo;
    }

    /**
     * 实现查找切换商品分类信息
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value="查询切换分类商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum",value="分页开始索引",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "limit",value="每页显示数量",required = true),
    })
    @GetMapping(value="/getSwitchProduct")
    public ResultVo getSwitchProduct(int pageNum,int limit){
        ResultVo resultVo = categoryService.listSwitchCategoryProduct(pageNum,limit);
        return resultVo;
    }

    /**
     * 实现查询楼层分类信息功能
     * @return 如果查找成功以ResultVo形式返回
     */
    @ApiOperation(value="查询楼层分类信息")
    @GetMapping(value = "/getFloorCategory")
    public ResultVo getFloorCategory(){
        ResultVo resultVo = categoryService.listFloorCategory();
        return resultVo;
    }
}
