package com.scorpion.controller;

import com.scorpion.entity.IuFeedBack;
import com.scorpion.service.IuFeedBackService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/7/5
 */
@Api(tags = "意见反馈管理",value = "提供意见反馈业务相关接口")
@RestController
@CrossOrigin
@RequestMapping("/iuFeedBack")
public class FeedBackController {
    @Resource
    private IuFeedBackService iuFeedBackService;

    @ApiOperation(value = "查找意见反馈接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "INTEGER",name = "pageNum",value = "页码",required = true),
            @ApiImplicitParam(dataType = "INTEGER",name = "limit",value = "每页数量",required = true),
            @ApiImplicitParam(dataType = "String",name = "token",value = "令牌",required = true)
    })
    @GetMapping("/get")
    public ResultVo getFeedBack(int pageNum, int limit, @RequestHeader("token") String token){
        ResultVo resultVo = iuFeedBackService.listFeedback(token, pageNum, limit);
        return resultVo;
    }

    @ApiOperation(value="添加意见反馈接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "令牌",required = true)
    })
    @PostMapping("/add")
    public ResultVo postFeedBack(@RequestHeader("token") String token, @RequestBody() IuFeedBack feedBack){
        ResultVo resultVo = iuFeedBackService.addFeedBack(token, feedBack);
        return resultVo;
    }

    @ApiOperation(value = "通过ID查找意见反馈详情")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "令牌",required = true)
    })
    @GetMapping("/getDetail/{id}")
    public ResultVo getFeedBackDetail(@RequestHeader("token") String token,@PathVariable("id") int id){
        ResultVo resultVo = iuFeedBackService.getFeedBackById(id);
        return resultVo;
    }
}
