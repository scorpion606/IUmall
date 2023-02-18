package com.scorpion.controller;

import com.scorpion.service.CollectService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/9/11
 */
@Api(tags = "收藏管理",value = "提供收藏相关接口")
@RestController
@CrossOrigin
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @ApiOperation(value = "收藏接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
    })
    @PostMapping("/update/{valueId}/{type}")
    public ResultVo updateCollectStatus(@RequestHeader("token") String token,
                                        @PathVariable("valueId") int valueId,
                                        @PathVariable("type") int type){
        ResultVo resultVo = collectService.addCollect(token, valueId, type);
        return resultVo;
    }
    @ApiOperation(value = "取消收藏接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
    })
    @DeleteMapping("/cancelCollect/{valueId}/{type}")
    public ResultVo cancelCollect(@RequestHeader("token") String token,
                                        @PathVariable("valueId") int valueId,
                                        @PathVariable("type") int type){
        ResultVo resultVo = collectService.cancelCollect(token, valueId, type);
        return resultVo;
    }

    @ApiOperation(value = "是否收藏接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
    })
    @GetMapping("/hasCollect/{valueId}/{type}")
    public ResultVo hasCollect(@RequestHeader("token") String token,
                                  @PathVariable("valueId") int valueId,
                                  @PathVariable("type") int type){
        ResultVo resultVo = collectService.hasCollect(token, valueId, type);
        return resultVo;
    }


    @ApiOperation(value = "查找收藏数据")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "用户令牌",required = true),
    })
    @GetMapping("/getCollect/{type}")
    public ResultVo getCollect(@RequestHeader("token") String token,
                               @PathVariable("type") int type){
        ResultVo resultVo = collectService.selectCollect(token, type);
        return resultVo;
    }
}
