package com.scorpion.controller;

import com.scorpion.service.IuTabsService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/6/17
 */
@Api(tags = "标签管理",value = "提供首页标签管理相关接口")
@RestController
@CrossOrigin
@RequestMapping("/iuTabs")
public class TabsController {
    @Resource
    private IuTabsService iuTabsService;

   @ApiOperation("查找首页标签接口")
    @GetMapping("/getIuTabs")
    public ResultVo getIuTabs(){
        ResultVo resultVo = iuTabsService.listIuTabs();
        return resultVo;
    }
    @ApiOperation("查找我的收藏标签")
    @GetMapping("/getCollectTabs")
    public ResultVo getTabsToCollect(){
        ResultVo resultVo = iuTabsService.listTabsToCollect();
        return resultVo;
    }
}
