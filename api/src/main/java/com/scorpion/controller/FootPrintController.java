package com.scorpion.controller;

import com.scorpion.service.IuFootPrintService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/7/1
 */
@Api(tags = "我的足迹管理",value = "提供我的足迹业务相关接口")
@RestController
@CrossOrigin
@RequestMapping("/iuFootPrint")
public class FootPrintController {
    @Resource
    private IuFootPrintService iuFootPrintService;

    @ApiOperation(value = "添加足迹历史接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @PostMapping("/add/{pId}")
    public ResultVo PostFootPrint(@RequestHeader("token") String token,@PathVariable("pId") int pId){
        return iuFootPrintService.addFootprint(token,pId);
    }

    @ApiOperation(value = "查找30天内的足迹历史")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @GetMapping("list")
    public ResultVo getFootPrint(@RequestHeader("token") String token){
        ResultVo resultVo = iuFootPrintService.listFootPrint(token);
        return resultVo;
    }

    @ApiOperation(value = "查找某一天内的足迹浏览历史接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true),
            @ApiImplicitParam(dataType = "String",name = "date",value = "日期",required = true)
    })
    @GetMapping("listOneDay")
    public ResultVo getLessOneDayFootPrint(@RequestHeader("token") String token,String date){
        ResultVo resultVo = iuFootPrintService.listLessOneDayFootPrint(token, date);
        return resultVo;
    }

}
