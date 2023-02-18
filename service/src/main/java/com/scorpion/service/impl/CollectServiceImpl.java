package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.ProductVo;
import com.scorpion.entity.Users;
import com.scorpion.mapper.IuCollectMapper;
import com.scorpion.mapper.ProductMapper;
import com.scorpion.service.CollectService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author scorpion
 * @date 2022/9/7
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private IuCollectMapper collectMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    /**
     *
     * @param token 用户令牌
     * @param valueId 被收藏Id
     * @param type 收藏类型
     * @return 返回ResultVo对象
     * step:
     * 1、通过token到redis中查找用户ID
     * 2、先查找redis中是否有该被收藏ID
     * 3、如果缓存中没有该，则直接插入
     * 4、如果数据库中有该被收藏数据，则更新收藏表中的逻辑删除状态
     */
    @Override
    public ResultVo addCollect(String token, int valueId, int type) {
        ResultVo resultVo=null;
        /*if(stringRedisTemplate.hasKey(redisKey.token+token)){
            String userJson = stringRedisTemplate.opsForValue().get(redisKey.token + token);
            try {
                if(userJson==null) {
                    Users user = objectMapper.readValue(userJson, Users.class);
                    Integer userId = user.getUserId();
                    Example example = new Example(IuCollect.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andEqualTo("userId", userId)
                            .andEqualTo("valueId", valueId);
                    IuCollect collects = collectMapper.selectOneByExample(example);
                    if (collects == null) {
                        IuCollect collect = IuCollect.builder()
                                .userId(userId)
                                .valueId(valueId)
                                .type(type)
                                .status(Boolean.TRUE)
                                .addTime(new Date())
                                .updateTime(new Date())
                                .deleted(Boolean.FALSE)
                                .build();
                        int i = collectMapper.insertSelective(collect);
                        if (i > 0) {
                            resultVo = new ResultVo(ResponseStatus.success, "collect success", null);
                        } else {
                            resultVo = new ResultVo(ResponseStatus.fail, "collect fail", null);
                        }
                    } else {
                        if (collects.getStatus().equals(Boolean.FALSE)) {
                            int i = collectMapper.updateStatus(userId, valueId, Boolean.TRUE);
                            if (i > 0) {
                                resultVo = new ResultVo(ResponseStatus.success, "collect success", null);
                            } else {
                                resultVo = new ResultVo(ResponseStatus.fail, "collect fail", null);
                            }
                        } else {
                            int i = collectMapper.updateStatus(userId, valueId, Boolean.FALSE);
                            if (i > 0) {
                                resultVo = new ResultVo(ResponseStatus.success, "cancel collect success", null);
                            } else {
                                resultVo = new ResultVo(ResponseStatus.fail, "cancel collect fail", null);
                            }
                        }
                    }
                }else{
                    resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }*/
        String tokenKey= RedisKey.token+token;

        if(stringRedisTemplate.hasKey(tokenKey)){
            String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
            if(userJson!=null){
                try {
                    Users user = objectMapper.readValue(userJson, Users.class);
                    Integer userId = user.getUserId();
                    String collectKey = RedisKey.getCollectKey(userId,type);
                    String vId=Integer.toString(valueId);
                    stringRedisTemplate.opsForZSet().add(collectKey,vId,System.currentTimeMillis());
                    resultVo=new ResultVo(ResponseStatus.success,"collect success",null);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    resultVo=new ResultVo(ResponseStatus.fail,"collect fail",null);
                }

            }
        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }
        return resultVo;
    }

    /**
     *
     * @param token 用户令牌
     * @param valueId 被收藏Id
     * @param type 收藏类型
     * @return
     */
    @Override
    public ResultVo cancelCollect(String token, int valueId, int type) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        if(stringRedisTemplate.hasKey(tokenKey)){
            String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
            if(userJson!=null){
                try {
                    Users user = objectMapper.readValue(userJson, Users.class);
                    Integer userId = user.getUserId();
                    String collectKey = RedisKey.getCollectKey(userId, type);
                    String vId = Integer.toString(valueId);
                    stringRedisTemplate.opsForZSet().remove(collectKey,vId);
                    resultVo=new ResultVo(ResponseStatus.success,"remove success",null);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    resultVo=new ResultVo(ResponseStatus.fail,"remove fail",null);
                }

            }
        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }
        return resultVo;
    }

    @Override
    public ResultVo hasCollect(String token, int valueId, int type) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        if(stringRedisTemplate.hasKey(tokenKey)){
            String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Integer userId = user.getUserId();
                String collectKey = RedisKey.getCollectKey(userId, type);
                String vId = Integer.toString(valueId);
                Double score = stringRedisTemplate.opsForZSet().score(collectKey, vId);
                if(score!=null){
                   resultVo=new ResultVo(ResponseStatus.success,"select success",true);
                }else{
                    resultVo=new ResultVo(ResponseStatus.success,"select non-existent",false);
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
     * 1、通过token查找用户Id
     * 2、通过用户Id和type查找收藏数据
     * @param token 用户令牌
     * @param type 收藏类型
     * @return
     */
    @Override
    public ResultVo selectCollect(String token,int type) {
        ResultVo resultVo=null;
        String tokenKey = RedisKey.token + token;
        if(stringRedisTemplate.hasKey(tokenKey)){
            String userJson = stringRedisTemplate.opsForValue().get(tokenKey);
            if(userJson!=null){
                Users user = null;
                try {
                    user = objectMapper.readValue(userJson, Users.class);
                    Integer userId = user.getUserId();
                    String collectKey = RedisKey.getCollectKey(userId, type);
                    Set<String> valueIds = stringRedisTemplate.opsForZSet().reverseRange(collectKey, 0, -1);
                    if(valueIds!=null) {
                        List<ProductVo> list = new ArrayList<>();
                        for (String valueId : valueIds) {
                            ProductVo productVos = productMapper.selectProductByProductId(Integer.valueOf(valueId));
                            list.add(productVos);
                        }
                        resultVo=new ResultVo(ResponseStatus.success,"select success",list);
                    }else{
                        resultVo=new ResultVo(ResponseStatus.fail,"select fail",null);
                    }

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    resultVo=new ResultVo(ResponseStatus.fail,"JsonProcessingException",null);
                }


            }
        }else{
            resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"login expired",null);
        }
        return resultVo;
    }
}
