package com.scorpion.controller;

import com.scorpion.service.IuSearchHistoryService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/4/21
 */
@Api(tags = "搜索历史管理",value = "提供搜索历史相关接口")
@CrossOrigin
@RequestMapping("/searchHistory")
@RestController
public class SearchHistoryController {
    @Resource
    private IuSearchHistoryService iuSearchHistoryService;

    @ApiOperation("查找用户搜索历史接口")
    @GetMapping("/getSearchHistory/{userId}/{start}/{end}")
    public ResultVo getSearchHistory(@PathVariable("userId") int userId,
                                     @PathVariable("start") int start,
                                     @PathVariable("end") int end){
        ResultVo resultVo = iuSearchHistoryService.listSearchHistory(userId,start,end);
        return resultVo;
    }

    @ApiOperation(value = "保存搜索历史记录接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "Integer",name = "userId",value="用户ID",required = true),
                    @ApiImplicitParam(dataType = "Integer",name = "top",value="Redis存储搜索历史上限",required = true),
                    @ApiImplicitParam(dataType = "String",name = "keyWord",value="搜索记录",required = true)
            }
    )
    @PostMapping("/save")
    public ResultVo PostSearchHistory(int userId,int top,String keyWord){
        ResultVo resultVo = iuSearchHistoryService.saveSearchHistory(userId, top, keyWord);
        return resultVo;
    }

    @ApiOperation(value = "删除搜索历史记录接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "INTEGER",name = "userId",value = "用户Id",required = true),
                    @ApiImplicitParam(dataType = "String",name = "keyword",value = "搜索记录",required = true)
            }
    )
    @DeleteMapping("/remove/{userId}")
    public ResultVo deleteSearchHistory(@PathVariable("userId") int userId,String keyword){
        ResultVo resultVo = iuSearchHistoryService.deleteSearchHistoryBuKeyword(userId, keyword);
        return resultVo;
    }

    @ApiOperation(value = "删除全部搜索历史记录接口")
    @DeleteMapping("/removeAll/{userId}")
    public ResultVo deleteAll(@PathVariable("userId") int userId){
        ResultVo resultVo = iuSearchHistoryService.deleteAll(userId);
        return resultVo;
    }
}
