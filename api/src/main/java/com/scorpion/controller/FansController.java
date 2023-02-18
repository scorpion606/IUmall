package com.scorpion.controller;

import com.scorpion.service.FansService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/10/4
 */
@Api(tags = "粉丝管理",value = "提供粉丝业务相关接口")
@CrossOrigin
@RequestMapping("/fans")
@RestController
public class FansController {
    @Resource
    private FansService fansService;

    @ApiOperation(value = "获取粉丝列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true)
    })
    @GetMapping("/getFansList")
    public ResultVo getFansList(@RequestHeader("token") String token){
        ResultVo resultVo = fansService.listFans(token);
        return resultVo;
    }

    @ApiOperation(value = "搜索我的粉丝")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
            @ApiImplicitParam(dataType = "String",name = "keyWord",value = "我的粉丝关键词",required = true)
    })
    @GetMapping("/searchFans")
    public ResultVo searchFans(@RequestHeader("token") String token,@RequestParam("keyWord") String keyWord){
        ResultVo resultVo = fansService.searchFans(token, keyWord);
        return resultVo;
    }
}
