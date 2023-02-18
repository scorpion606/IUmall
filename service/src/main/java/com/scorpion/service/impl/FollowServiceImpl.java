package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.Fans;
import com.scorpion.entity.Follow;
import com.scorpion.entity.UserVO;
import com.scorpion.entity.Users;
import com.scorpion.mapper.UsersMapper;
import com.scorpion.service.FollowService;
import com.scorpion.vo.CountVo;
import com.scorpion.vo.RedisKey;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author scorpion
 * @date 2022/10/4
 */
@Service
public class FollowServiceImpl implements FollowService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private UsersMapper usersMapper;
    /**
     * 1，通过token构造redis关键词获取userId
     * 2，通过token构造redis关键词follow:{token}
     * 3，通过followId构造redis关键词fans:{followId}
     * 4，构造follow对象和fans对象
     * 5，通过redis将follow对象和fans对象存入redis中，
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return
     */
    @Override
    public ResultVo addFollow(String token, int followId) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;

        String fansKey = RedisKey.getFansKey(followId);

        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        try {
            if(userJson!=null) {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String followKey = RedisKey.getFollowKey(userId);
                Follow follow = Follow.builder()
                        .userId(userId)
                        .followedId(followId)
                        .status(Boolean.TRUE)
                        .specialAttention(Boolean.FALSE)
                        .deleted(Boolean.FALSE)
                        .addTime(new Date())
                        .updateTime(new Date())
                        .build();
                stringRedisTemplate.opsForHash().put(followKey,String.valueOf(followId),objectMapper.writeValueAsString(follow));
                Fans fans = Fans.builder()
                        .userId(followId)
                        .followerId(userId)
                        .status(Boolean.FALSE)
                        .deleted(Boolean.FALSE)
                        .addTime(new Date())
                        .updateTime(new Date())
                        .build();
                stringRedisTemplate.opsForHash().put(fansKey,String.valueOf(followId),objectMapper.writeValueAsString(fans));
                resultVo=new ResultVo(ResponseStatus.success,"add success",null);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            resultVo=new ResultVo(ResponseStatus.fail,"add fail",null);
        }

        return resultVo;
    }

    /**
     * 1，通过token构造redis关键词获取user对象
     * 2，通过token构造获取我的关注的关键词
     * 3，通过userId构造获取我的粉丝的的关键词
     * 4，获取动态数量，关注数量，粉丝数量
     * @param token 用户令牌
     * @return
     */
    @Override
    public ResultVo listCount(String token) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;

        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null){
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String followKey = RedisKey.getFollowKey(userId);
                String fansKey = RedisKey.getFansKey(userId);
                Long followCount = stringRedisTemplate.opsForHash().size(followKey);
                Long fansCount = stringRedisTemplate.opsForHash().size(fansKey);
                CountVo count = CountVo.builder()
                        .followCount(followCount)
                        .FansCount(fansCount)
                        .build();
                resultVo=new ResultVo(ResponseStatus.success,"select success",count);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                resultVo=new ResultVo(ResponseStatus.fail,"select fail",null);
            }

        }
        return resultVo;
    }

    /**
     * 1，通过token构造followKey获取followJson数据
     * @param token 用户令牌
     * @return
     */
    @Override
    public ResultVo listFollow(String token) {
        ResultVo resultVo=null;
        String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
        if(userJson!=null) {
            Users user = null;
            try {
                user = objectMapper.readValue(userJson, Users.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            String followKey = RedisKey.getFollowKey(user.getUserId());
            List<Object> followList = stringRedisTemplate.opsForHash().values(followKey);
            if(followList!=null&&followList.size()>0) {
                List<Integer> fList=new ArrayList<>();
                List<Integer> sList=new ArrayList<>();
                Map<String,List<UserVO>> map=new HashMap<>();
                for (Object o : followList) {
                    try {
                        Follow follow = objectMapper.readValue((String) o, Follow.class);
                            if (follow.getSpecialAttention().equals(false)) {
                                fList.add(follow.getFollowedId());
                            } else if (follow.getSpecialAttention().equals(true)) {
                                sList.add(follow.getFollowedId());
                            }
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
                if(fList!=null&&fList.size()>0) {
                        List<UserVO> usersList = usersMapper.selectList(fList);
                        map.put("follow", usersList);
                }
                if(sList!=null&&sList.size()>0){
                    List<UserVO> userList = usersMapper.selectList(sList);
                    map.put("special",userList);
                }
                resultVo=new ResultVo(ResponseStatus.success,"select success",map);
            }else{
                resultVo=new ResultVo(ResponseStatus.success,"list is empty",null);
            }
        }
        return resultVo;
    }

    /**
     * 1，通过token构造获取用户信息的关键词 "wx_token"+{token}
     * 2，通过从redis获取的userId构造获取关注人信息的关键词 "follow"+{userId}
     * 3，通过关键词"follow"+{userId}和followId获取follow对象信息
     * 4，构造新的follow对象,修改follow对象的specialAttention特别关注状态,重新插入hash数据
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return
     */
    @Override
    public ResultVo addSpecialFollow(String token, int followId) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null){
            Users user = null;
            try {
                user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String followKey = RedisKey.getFollowKey(userId);
                String followJson = (String)stringRedisTemplate.opsForHash().get(followKey, String.valueOf(followId));
                if(followJson != null){
                    Follow oldFollow = objectMapper.readValue(followJson, Follow.class);
                    Follow newFollow = Follow.builder()
                            .id(oldFollow.getId())
                            .userId(oldFollow.getUserId())
                            .followedId(oldFollow.getFollowedId())
                            .status(oldFollow.getStatus())
                            .specialAttention(Boolean.TRUE)
                            .deleted(oldFollow.getDeleted())
                            .addTime(oldFollow.getAddTime())
                            .updateTime(new Date())
                            .build();
                    stringRedisTemplate.opsForHash().put(followKey,String.valueOf(followId),objectMapper.writeValueAsString(newFollow));
                    resultVo=new ResultVo(ResponseStatus.success,"update success",null);
                }
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
     *
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return
     */
    @Override
    public ResultVo cancelFollow(String token, int followId) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null){
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String followKey = RedisKey.getFollowKey(userId);
                String fansKey = RedisKey.getFansKey(followId);
                Long i = stringRedisTemplate.opsForHash().delete(followKey, String.valueOf(followId));
                Long j = stringRedisTemplate.opsForHash().delete(fansKey, String.valueOf(followId));
                if(i*j>0){
                    resultVo=new ResultVo(ResponseStatus.success,"delete success",null);
                }
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
     * 1，通过token构造获取用户信息的关键词 "wx_token"+{token}
     * 2，通过从redis获取的userId构造获取关注人信息的关键词 "follow"+{userId}
     * 3，通过关键词"follow"+{userId}和followId获取follow对象信息
     * 4，通过我的关注关键词相似查询获取user信息，对比user信息中的userId和follow对象信息中的followId是否相等
     * 5，如果相等，添加到List列表中
     * @param token 用户令牌
     * @param keyWord 我的关注关键词
     * @return
     */
    @Override
    public ResultVo searchFollow(String token, String keyWord) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
        if(userJson!=null){
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String followKey = RedisKey.getFollowKey(userId);
                Set<Object> keys = stringRedisTemplate.opsForHash().keys(followKey);
                List<Integer> list=new ArrayList<>();
                for (Object o : keys) {
                    Integer followId = objectMapper.readValue((String) o, Integer.class);
                    list.add(followId);
                }
                List<UserVO> users = usersMapper.selectListBykeyWord(list,"%"+keyWord+"%");

                resultVo=new ResultVo(ResponseStatus.success,"search success",users);
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
