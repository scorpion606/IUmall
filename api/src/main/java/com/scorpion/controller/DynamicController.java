package com.scorpion.controller;

import com.scorpion.service.DynamicService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/10/16
 */
@Api(tags = "动态管理",value = "提供动态业务相关接口")
@CrossOrigin
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Resource
    private DynamicService dynamicService;

    @ApiOperation(value = "分页获取动态列表")
    @GetMapping("/get/{pageNum}/{limit}")
    public ResultVo getDynamic(@PathVariable("pageNum") int pageNum,@PathVariable("limit") int limit){
        ResultVo resultVo = dynamicService.listDynamic(pageNum, limit);
        return resultVo;
    }
}
