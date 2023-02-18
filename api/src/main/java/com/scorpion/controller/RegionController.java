package com.scorpion.controller;

import com.scorpion.service.DtsRegionService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2022/3/27
 */
@Api(tags = "行政区域管理",value = "提供行政管理相关接口")
@RestController
@CrossOrigin
@RequestMapping("/region")
public class RegionController {
    @Resource
    private DtsRegionService dtsRegionService;

    /**
     * 实现查找一级、二级、三级分类功能
     * @return 如果查找成功返回ResultVo对象
     */
   @ApiOperation(value = "查找行政区域接口")
   @GetMapping("/getRegion")
   public ResultVo getRegion(){
       ResultVo resultVo = dtsRegionService.listDtsRegion();
       return resultVo;
   }
}
