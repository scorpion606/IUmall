package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.Fans;
import com.scorpion.entity.UserVO;
import com.scorpion.entity.Users;
import com.scorpion.mapper.FansMapper;
import com.scorpion.mapper.UsersMapper;
import com.scorpion.service.FansService;
import com.scorpion.vo.RedisKey;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/10/4
 */
@Service
public class FansServiceImpl implements FansService {
    @Resource
    private FansMapper fansMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private UsersMapper userMapper;

    @Override
    public ResultVo listFans(String token) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null) {
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String fansKey = RedisKey.getFansKey(userId);
                List<Integer> list=new ArrayList<>();
                List<Object> fans = stringRedisTemplate.opsForHash().values(fansKey);
                for (Object o : fans) {
                    Fans fan= objectMapper.readValue((String) o, Fans.class);
                    list.add(fan.getFollowerId());
                }
                List<UserVO> userList = userMapper.selectList(list);
                resultVo=new ResultVo(ResponseStatus.success,"select success",userList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                resultVo=new ResultVo(ResponseStatus.fail,"JsonProcessingException",null);
            }
        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }

        return resultVo;
    }

    /**
     * 1，构造获取用户信息的redis关键词 "wx_token"+{token}
     * 2，通过获取的userId构造fansKey获取粉丝信息 关键词 “fans”+{userId}
     * 3，通过“fans”+{userId}获取粉丝信息，获取followerId集合
     * 4，通过followerId集合和我的粉丝关键词获取粉丝用户信息
     * @param token 用户令牌
     * @param keyWord 我的粉丝关键词
     * @return
     */
    @Override
    public ResultVo searchFans(String token, String keyWord) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null){
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String fansKey = RedisKey.getFansKey(userId);
                List<Object> values = stringRedisTemplate.opsForHash().values(fansKey);
                List<Integer> list=new ArrayList<>();
                for (Object o : values) {
                    Fans fans = objectMapper.readValue((String) o, Fans.class);
                    list.add(fans.getFollowerId());
                }
                List<UserVO> userVOS = userMapper.selectListBykeyWord(list, "%"+keyWord+"%");
                resultVo=new ResultVo(ResponseStatus.success,"search success",userVOS);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                resultVo=new ResultVo(ResponseStatus.fail,"JsonProcessingException",null);
            }


        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }
        return resultVo;
    }
}
