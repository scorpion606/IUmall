package com.scorpion.controller;

import com.scorpion.service.IuNavigationService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/6/18
 */
@Api(tags = "首页导航分类管理",value = "提供首页导航分类接口")
@CrossOrigin
@RequestMapping("/index")
@RestController
public class NavigationController {
    @Resource
    private IuNavigationService iuNavigationService;

    @ApiOperation(value = "查找首页导航分类接口")
    @GetMapping("/getNavigation/{parentId}")
    public ResultVo getNavigation(@PathVariable("parentId") int parentId){
        return iuNavigationService.listNavigation(parentId);
    }

}
