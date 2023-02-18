package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IuAd;
import com.scorpion.mapper.IuAdMapper;
import com.scorpion.service.IuAdService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2022/6/18
 */
@Service
public class IuAdServiceImpl implements IuAdService {
    @Resource
    private IuAdMapper iuAdMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public ResultVo getAd() {
        ResultVo resultVo=null;
        try {
            String adJson = stringRedisTemplate.opsForValue().get("ad");
            if(adJson!=null){
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuAd.class);
                List<IuAd> iuAd = objectMapper.readValue(adJson, javaType);
                resultVo=new ResultVo(ResponseStatus.success,"list success",iuAd);
            }else{
                synchronized (this){
                    String json = stringRedisTemplate.opsForValue().get("ad");
                    if(json==null){
                        Example example = new Example(IuAd.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("position",1)
                                .andEqualTo("status",0)
                                .andEqualTo("deleted",0);
                        List<IuAd> iuAds = iuAdMapper.selectByExample(example);
                        if(iuAds!=null&&iuAds.size()>0) {
                            stringRedisTemplate.opsForValue().set("ad", objectMapper.writeValueAsString(iuAds), 1, TimeUnit.DAYS);
                            resultVo=new ResultVo(ResponseStatus.success,"list success",iuAds);
                        }else{
                            stringRedisTemplate.opsForValue().set("ad","[]",10,TimeUnit.SECONDS);
                        }
                    }else{
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuAd.class);
                        List<IuAd> iuAd = objectMapper.readValue(json, javaType);
                        resultVo=new ResultVo(ResponseStatus.success,"list success",iuAd);
                    }

                }
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
            resultVo=new ResultVo(ResponseStatus.fail,"list JsonProcessingException",null);
        }

        return resultVo;
    }
}
