package com.scorpion.controller;

import com.scorpion.service.FollowService;
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
@Api(tags ="关注管理", value = "提供关注业务相关接口")
@CrossOrigin
@RequestMapping("/follow")
@RestController
public class FollowController {
    @Resource
    private FollowService followService;

    @ApiOperation(value = "点击关注接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "followId",value = "关注人Id",required = true)
    })
    @PostMapping("/add/{followId}")
    public ResultVo PostFollow(@RequestHeader("token") String token, @PathVariable("followId") int followId){
        ResultVo resultVo = followService.addFollow(token, followId);
        return resultVo;
    }

    @ApiOperation(value = "获取动态、关注、粉丝总数")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true)
    })
    @GetMapping("/getCount")
    public ResultVo getCount(@RequestHeader("token") String token){
        ResultVo resultVo = followService.listCount(token);
        return resultVo;
    }

    @ApiOperation(value = "获取关注列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true)
    })
    @GetMapping("/getFollowList")
    public ResultVo getFollowList(@RequestHeader("token") String token){
        ResultVo resultVo = followService.listFollow(token);
        return resultVo;
    }

    @ApiOperation(value="特别关注")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true)
    })
    @PostMapping("/specialFollow/{followId}")
    public ResultVo PostSpecialFollow(@RequestHeader("token") String token,@PathVariable("followId") int followId){
        ResultVo resultVo = followService.addSpecialFollow(token, followId);
        return resultVo;
    }

    @ApiOperation(value = "取消关注")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true)
    })
    @DeleteMapping("/cancelFollow/{followId}")
    public ResultVo DeleteFollow(@RequestHeader("token") String token,@PathVariable("followId") int followId){
        ResultVo resultVo = followService.cancelFollow(token, followId);
        return resultVo;
    }
    @ApiOperation(value = "搜索我的关注")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
            @ApiImplicitParam(dataType = "String",name = "keyWord",value = "我的关注关键词",required = true)
    })
    @GetMapping("/search")
    public ResultVo search(@RequestHeader("token") String token,@RequestParam("keyWord") String keyWord){
        ResultVo resultVo = followService.searchFollow(token, keyWord);
        return resultVo;
    }
}
