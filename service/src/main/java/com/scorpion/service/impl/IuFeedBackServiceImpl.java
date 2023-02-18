package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IuFeedBack;
import com.scorpion.entity.Users;
import com.scorpion.mapper.IuFeedBackMapper;
import com.scorpion.service.IuFeedBackService;
import com.scorpion.vo.PageHelper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/7/5
 */
@Service
public class IuFeedBackServiceImpl implements IuFeedBackService {
    @Resource
    private IuFeedBackMapper iuFeedBackMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public ResultVo listFeedback(String token,int pageNum,int limit) {
        ResultVo resultVo=null;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            Integer userId = user.getUserId();
            IuFeedBack feedBack = IuFeedBack.builder()
                    .userId(userId)
                    .deleted(Boolean.FALSE)
                    .build();
            int count = iuFeedBackMapper.selectCount(feedBack);
            int pageCount=count%limit==0?count/limit:count/limit+1;
            int start=(pageNum-1)*limit;
            List<IuFeedBack> iuFeedBacks = iuFeedBackMapper.selectIuFeedBack(userId, start, limit);
            resultVo=new ResultVo(ResponseStatus.success,"list success",new PageHelper<>(count,pageCount,iuFeedBacks));
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return resultVo;
    }

    @Override
    public ResultVo addFeedBack(String token, IuFeedBack feedBack) {
        ResultVo resultVo=null;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            Integer userId = user.getUserId();
            String nickName = user.getNickName();
            feedBack.setUserId(userId);
            feedBack.setUsername(nickName);
            feedBack.setStatus(1);
            if(feedBack.getPicUrls()!=null&&!"".equals(feedBack.getPicUrls())){
                feedBack.setHasPicture(Boolean.TRUE);
            }
            feedBack.setHasPicture(Boolean.FALSE);
            feedBack.setAddTime(new Date());
            feedBack.setUpdateTime(new Date());
            feedBack.setDeleted(Boolean.FALSE);
            int i = iuFeedBackMapper.insertSelective(feedBack);
            if(i>0){
                resultVo=new ResultVo(ResponseStatus.success,"add success",null);
            }else{
                resultVo=new ResultVo(ResponseStatus.fail,"add fail",null);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return resultVo;
    }

    @Override
    public ResultVo getFeedBackById(int id) {
        IuFeedBack feedBack = IuFeedBack.builder()
                .id(id)
                .deleted(Boolean.FALSE)
                .build();
        IuFeedBack iuFeedBack = iuFeedBackMapper.selectOne(feedBack);
        return new ResultVo(ResponseStatus.success,"list success",iuFeedBack);
    }
}
