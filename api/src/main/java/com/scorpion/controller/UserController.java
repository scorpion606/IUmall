package com.scorpion.controller;

import com.scorpion.entity.Users;
import com.scorpion.service.UserService;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.WxAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2021/10/6
 */
@RestController
//允许跨域请求
@CrossOrigin
@RequestMapping(value = "/user")
@Api(tags = "用户管理",value = "提供用户登录和注册接口")
public class UserController {
    @Resource
    private UserService userService;


    /**
     * 实现注册功能
     * @user user对象
     * @return 如果注册成功返回ResultVo对象
     */
    @ApiOperation(value = "用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户注册密码",required = true)
    })
    @PostMapping(value = "/register")
    public ResultVo register(String username,String password) {
        return userService.register(username, password);
    }



    /**
     * 实现登陆功能
     * @param username 登录用户名
     * @param password 登录密码
     * @return 如果登陆成功返回ResultVo对象
     */
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户登录密码",required = true)
    })
    @GetMapping(path = "/login")
    public ResultVo login(@RequestParam(value = "username",required = true) String username,
                          @RequestParam(value = "password",required = true) String password){
        
        return userService.login(username,password);

    }

    @ApiOperation(value="个人中心校验token是否过期")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "token",value="用户登录令牌",required = true)
    })
    @GetMapping(value = "/checkToken")
    public ResultVo checkToken(@RequestHeader("token") String token){
        ResultVo resultVo = userService.checkToken(token);
        return resultVo;
    }

    @ApiOperation(value = "微信登录获取sessionId接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "code",value="登录临时凭证",required = true)
    })
    @GetMapping("/getSessionId")
    public ResultVo getSessionId(String code){
        ResultVo resultVo = userService.getSessionId(code);
        return resultVo;
    }

    @ApiOperation(value = "微信认证登录")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "wxAuth",name = "wxAuth",value = "微信登录认证对象",required = true)
    })
    @PostMapping("/authLogin")
    public ResultVo authLogin(@RequestBody() WxAuth wxAuth){
        ResultVo resultVo = userService.authLogin(wxAuth);
        return resultVo;
    }

    @ApiOperation(value = "获取微信用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Boolean",name = "refresh",value = "是否重新刷新token",required = true),
            @ApiImplicitParam(dataType="String",name = "token",value="用户登录令牌",required = true)
    })
    @GetMapping("/getWxUserInfo")
    public ResultVo getWxUserInfo(Boolean refresh,@RequestHeader("token") String token){
        ResultVo resultVo = userService.wxListUserInfo(token, refresh);
        return resultVo;
    }

    @ApiOperation(value = "修改用户个人信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Users",name = "user",value = "用户个人信息",required = true),
            @ApiImplicitParam(dataType="String",name = "token",value="用户令牌",required = true)
    })
    @PutMapping("/updateUserInfo")
    public ResultVo putUserInfo(@RequestBody Users user,@RequestHeader("token") String token){
        ResultVo resultVo = userService.wxUpdateUserInfo(user,token);
        return resultVo;
    }

    @ApiOperation(value = "退出登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "token",value="用户令牌",required = true)
    })
    @PostMapping("/logout")
    public ResultVo logout(@RequestHeader("token") String token){
        ResultVo resultVo = userService.removeUsrInfo(token);
        return resultVo;
    }
}
