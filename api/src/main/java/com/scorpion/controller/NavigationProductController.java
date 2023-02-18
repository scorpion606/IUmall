package com.scorpion.controller;

import com.scorpion.service.IuNavigationToProductService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/6/19
 */
@Api(tags = "导航分类商品管理",value = "提供导航分类商品接口")
@RestController
@CrossOrigin
@RequestMapping("/navigation")
public class NavigationProductController {
    @Resource
    private IuNavigationToProductService iuNavigationToProductService;
    @ApiOperation(value="查询导航分类商品接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "当前索引", required = true),
            @ApiImplicitParam(dataType = "Integer", name = "limit", value = "每页显示商品数量", required = true)
    })
    @GetMapping("/getNavigationProduct/{navigationId}")
    public ResultVo getNavigationProduct(@PathVariable("navigationId") int navigationId,int pageNum,int limit){
        return iuNavigationToProductService.listNavigationToProduct(navigationId,pageNum,limit);
    }
}
