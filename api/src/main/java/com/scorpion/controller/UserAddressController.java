package com.scorpion.controller;

import com.scorpion.entity.UserAddress;
import com.scorpion.service.UserAddressService;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2021/12/3
 */
@RestController
@RequestMapping(value="/userAddress")
@CrossOrigin
@Api(tags = "用户地址管理", value ="提供用户地址相关业务接口")
public class UserAddressController {
    @Resource
    private UserAddressService userAddressService;

    @ApiOperation(value="用户地址列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true)
    })
    @GetMapping("/list")
    public ResultVo getUserAddress(@RequestHeader("token") String token){
        ResultVo resultVo = userAddressService.selectUserAddress(token);
        return  resultVo;
    }

    @ApiOperation(value = "删除用户地址接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "aId",value="用户地址ID",required = true),
            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true),

    })
    @DeleteMapping("/deleteAddress/{aId}")
    public ResultVo deleteAddress(@PathVariable("aId") int aId,@RequestHeader("token") String token){
        ResultVo resultVo = userAddressService.deleteUserAddress(aId);
        return resultVo;
    }

    @ApiOperation(value = "修改用户地址是否默认地址接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "aId",value = "用户地址ID",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "dId",value="默认状态",required = true),
            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true),

    })
    @PutMapping("/updateUserAddress")
    public ResultVo PutUserAddress(int aId,int dId,@RequestHeader("token") String token){
        ResultVo resultVo = userAddressService.updateUserAddress(aId, dId);
        return resultVo;
    }

    @ApiOperation(value = "添加用户地址信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true),
    })
    @PostMapping("/addUserAddress")
    public ResultVo PostUserAddress(@RequestBody() UserAddress userAddress,@RequestHeader("token") String token){
        ResultVo resultVo = userAddressService.insertUserAddress(userAddress,token);
        return  resultVo;
    }

    @ApiOperation(value = "修改用户地址接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true),
    })
    @PutMapping("/updateChooseUserAddress")
    public ResultVo PutChooseUserAddress(@RequestBody() UserAddress editAddressForm,@RequestHeader("token") String token){
        ResultVo resultVo = userAddressService.updateChooseUserAddress(editAddressForm,token);
        return  resultVo;
    }
}
