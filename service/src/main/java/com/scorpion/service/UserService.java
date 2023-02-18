package com.scorpion.service;

import com.scorpion.entity.Users;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.WxAuth;

/**
 * @author scorpion
 * @date 2021/10/6
 */
public interface UserService {
    /**
     * 实现登录功能，调用mapper的QueryOne方法
     * @return 如果通过用户名查找成功，返回ResultVo对象
     */
    public ResultVo login(String username, String password);

    /**
     * 实现注册功能，调用mapper的QueryOne方法和insertUser方法
     * @param username 注册用户名
     * @param password 注册密码
     * @return
     */
    public ResultVo register(String username,String password);

    /**
     * 实现个人中心校验token是否过期
     * @param token
     * @return
     */
    public ResultVo checkToken(String token);

    /**
     * 获取sessionId,标记登录对象
     * @param code 微信登录凭证
     * @return 如果获取成功返回ResultVo对象
     */
    public ResultVo getSessionId(String code);

    /**
     * 微信认证登录
     * @param wxAuth 微信认证登录对象
     * @return 如果登录成功返回ResultVo对象
     */
    public ResultVo authLogin(WxAuth wxAuth);

    /**
     * 微信注册
     * @param users 用户信息
     * @return 如果注册成功返回ResultVo对象
     */
    public ResultVo wxRegister(Users users);

    /**
     * 微信登录
     * @param users 用户信息
     * @return 如果登录成功返回ResultVo对象
     */
    public ResultVo wxLogin(Users users);

    /**
     * 获取用户信息
     * @param token 令牌
     * @param refresh 是否刷新token
     * @return 如果获取成功返回ResultVo对象
     */
    public ResultVo wxListUserInfo(String token,Boolean refresh);

    /**
     * 修改用户个人信息
     * @param user 用户个人信息对象
     * @return 如果修改成功返回ResultVo对象
     */
    public ResultVo wxUpdateUserInfo(Users user,String token);

    /**
     * 通过token移除redis中的用户信息
     * @param token 用户令牌
     * @return
     */
    public ResultVo removeUsrInfo(String token);
}
