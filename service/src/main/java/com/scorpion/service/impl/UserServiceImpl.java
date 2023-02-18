package com.scorpion.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.Users;
import com.scorpion.mapper.UsersMapper;
import com.scorpion.service.UserService;

import com.scorpion.utils.MD5Util;
import com.scorpion.vo.*;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2021/10/6
 */
@Service
public class UserServiceImpl implements UserService {

    private String appId="wx4118728c41573040";

    private String secret="059603b2b87048520cba3d4901ef8304";

    @Resource
    private com.scorpion.service.util.wxUtil wxUtil;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UsersMapper userMapper;

    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public ResultVo login(String username, String password) {
        //根据用户名查询用户信息
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",username);
        List<Users> users = userMapper.selectByExample(example);

        //判断
        if(users.size()==0){
            return new ResultVo(ResponseStatus.fail,"登陆失败，用户名不存在!",null);   //返回验证失败原因

        }else{
            String md5Password = MD5Util.getMD5(password);                                      //对输入的密码进行加密

            if(users.get(0).getUserPassword().equals(md5Password)){                             //使用加密后的密码和查出来的密码进行匹配
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("username",username);
                map.put("nickName",users.get(0).getNickName());
                //使用JWT令牌加密
                JwtBuilder builder = Jwts.builder();
                String token=builder.setSubject(username)                                       //主题，就是token中携带的数据
                        .setIssuedAt(new Date())                                                //设置token生成时间
                        .setId(users.get(0).getUserId()+"")                                     //设置用户ID为tokenID
                        .setClaims(map)                                                         //map中可以存储用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis()+7*24*60*60*1000))    //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256,"5201314xn")    //设置加密方式和密码盐
                        .compact();

                //验证成功
                //  当登陆成功，将用户信息存入redis，key为token，value为users.get(0)
                try {
                    String userJson = objectMapper.writeValueAsString(users.get(0));
                    stringRedisTemplate.opsForValue().set(RedisKey.token+token, userJson, 30, TimeUnit.MINUTES);
                }catch (JsonProcessingException e){
                    e.printStackTrace();
                }
                return new ResultVo(ResponseStatus.success,token,users.get(0));
            }else {
                //验证失败，返回失败原因
                return new ResultVo(ResponseStatus.fail,"登陆失败，密码错误!",null);
            }
        }
    }

    @Override
    //添加事务
    @Transactional
    public ResultVo register(String username, String password) {
        //添加同步代码块，防止出现多人注册时多线程的线程堵塞
        synchronized (this) {
            //1，根据用户名查找，该用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userName",username);
            List<Users> users = userMapper.selectByExample(example);
            //2，如果没有被注册进行保存操作
            if (users.size() == 0) {
                Users user = new Users();
                String md5Password = MD5Util.getMD5(password);  //对注册密码进行MD5加密处理
                user.setUserName(username);                     //注册用户名
                user.setNickName(username);                     //用户昵称
                user.setUserPassword(md5Password);              //注册用户密码
                user.setAvatra(ResponseData.defaultImg);        //用户默认头像地址
                user.setCreatedBy(username);                    //创建人
                user.setUpdatedBy(username);                    //更新人
                user.setCreatedTime(new Date());                //创建时间
                user.setUpdatedTime(new Date());                //更新时间
                int i = userMapper.insertUseGeneratedKeys(user);
                if (i > 0) {

                    return new ResultVo(ResponseStatus.success, "注册成功!", user);
                } else {
                    return new ResultVo(ResponseStatus.fail, "注册失败!", null);
                }

            } else {
                return new ResultVo(ResponseStatus.fail, "该用户名已经被注册!", null);
            }
        }
    }

    @Override
    public ResultVo checkToken(String token) {
        return new ResultVo(ResponseStatus.success,"success",null);
    }

    @Override
    public ResultVo getSessionId(String code) {
        /**
         * 1.   拼接一个url，微信登录凭证校验接口
         * 2.   发起一个http的调用，获取微信的返回结果
         * 3.   存到redis
         * 4.   生成一个sessionId，返回给前端，作为当前需要登录用户的标识
         * 5.   生成一个sessionId，用户点击微信登录的时候，我们可以标识是谁点击微信登录
         */
        String url="https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        String replaceUrl = url.replace("{0}", appId).replace("{1}", secret).replace("{2}", code);
        String res = HttpUtil.get(replaceUrl);
        String uuid = UUID.randomUUID().toString().replace("-","");
        stringRedisTemplate.opsForValue().set(RedisKey.sessionId+uuid,res,30, TimeUnit.MINUTES);
        HashMap<String,String> map=new HashMap<>();
        map.put("sessionId",uuid);
        return new ResultVo(ResponseStatus.success,"get sessionId success",map);
    }

    @Override
    @Transactional
    public ResultVo authLogin(WxAuth wxAuth) {
        /**
         * 1    通过wxAuth中的值,要对它进行解密
         * 2    解密完成之后，会获取到微信用户信息 其中包含openId，性别，昵称，头像等信息
         * 3    openId是唯一的，需要去user表中查询openId是否存在，存在，证明此用户的身份登陆成功
         * 4    不存在，新用户，注册流程，登陆成功
         * 5    使用jwt技术，生成一个token，提供给前端toekn令牌，用户在下次访问的时候，携带token来访问
         * 6    后端通过对token的验证，知道此用户是否处于登录状态，以及是那个用户登录的
         */
        ResultVo resultVo=null;
        try {
            String url="https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
            String replaceUrl = url.replace("{0}", appId).replace("{1}", secret).replace("{2}", wxAuth.getCode());
            String res = HttpUtil.get(replaceUrl);
            String json = wxUtil.wxDecrypt(res,wxAuth.getEncryptedData(), wxAuth.getIv());

            WxUserInfo wxUserInfo = JSON.parseObject(json, WxUserInfo.class);

            JSONObject jsonObject = JSON.parseObject(res);
            String openId =(String)jsonObject.get("openid");

            if(openId!=null&&!"".equals(openId)){
                Example example = new Example(Users.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("openId",openId);
                Users users = userMapper.selectOneByExample(example);
                Users wxUser = new Users();
                wxUser.setNickName(wxUserInfo.getNickName());
                wxUser.setUserSex(wxUserInfo.getGender());
                wxUser.setAvatra(wxUserInfo.getAvatarUrl());
                wxUser.setOpenId(openId);
                wxUser.setUnionId(wxUserInfo.getUnionId());
                if(users==null){
//                    如果该用户不存在，证明该用户没有注册,注册该用户并登录
//                    调用注册接口
                   resultVo=this.wxRegister(wxUser);

                }else {
//                    该用户存在，则进行登录操作
                   resultVo= this.wxLogin(users);
                }
            }
        } catch (Exception e) {

            return new ResultVo(ResponseStatus.fail,"login exception",null);
        }
      return resultVo;
    }

    @Override
    public ResultVo wxRegister(Users users) {
        int i = userMapper.insertSelective(users);
        if(i>0){
            return this.wxLogin(users);
        }else{
            return new ResultVo(ResponseStatus.fail,"wx register fail",null);
        }
    }

    @Override
    public ResultVo wxLogin(Users users) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nickName",users.getNickName());
        //使用JWT令牌加密
        JwtBuilder builder = Jwts.builder();
        String token=builder.setSubject(users.getNickName())                                       //主题，就是token中携带的数据
                .setIssuedAt(new Date())                                                           //设置token生成时间
                .setId(users.getUserId()+"")                                                       //设置用户ID为tokenID
                .setClaims(map)                                                                    //map中可以存储用户的角色权限信息
                .setExpiration(new Date(System.currentTimeMillis()+7*24*60*60*1000))               //设置token过期时间
                .signWith(SignatureAlgorithm.HS256,"5201314xn")               //设置加密方式和密码盐
                .compact();
        users.setOpenId(null);
        users.setUnionId(null);
//        将用户信息存储redis缓存中
        stringRedisTemplate.opsForValue().set(RedisKey.token+token,JSON.toJSONString(users),7,TimeUnit.DAYS);
        return new ResultVo(ResponseStatus.success,token,users);
    }

    @Override
    public ResultVo wxListUserInfo(String token,Boolean refresh) {
        /**
         * 1    根据token，来验证此token是否有效
         * 2    refresh 如果为true 代表刷新 重新生成token和redis里面重新续期
         * 3    false直接返回用户信息 redis中查询出来
         */
        String json = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
        if(json==null&&"".equals(json)){
            return new ResultVo(ResponseStatus.LOGIN_FAIL,"该用户未登录",null);
        }
        Users wxUser = JSON.parseObject(json, Users.class);
       if(refresh){
//           重新登录续期
           return this.wxLogin(wxUser);
       }
       return new ResultVo(ResponseStatus.success,"list success",wxUser);
    }

    @Override
    public ResultVo wxUpdateUserInfo(Users user,String token) {
        /**
         * 1    根据前端传过来的用户对象修改用户个人信息
         */
        int i=0;
        try {
            stringRedisTemplate.opsForValue().set(RedisKey.token+token,new ObjectMapper().writeValueAsString(user));
            i= userMapper.updateByPrimaryKeySelective(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }
    }

    @Override
    public ResultVo removeUsrInfo(String token) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        Boolean delete = stringRedisTemplate.delete(tokenKey);
        if(delete){
            resultVo=new ResultVo(ResponseStatus.success,"remove success",null);
        }else{
            resultVo=new ResultVo(ResponseStatus.fail,"remove fail",null);
        }
        return resultVo;
    }
}
