package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IuTabs;
import com.scorpion.mapper.IuTabsMapper;
import com.scorpion.service.IuTabsService;
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
 * @date 2022/6/17
 */
@Service
public class IuTabsServiceImpl implements IuTabsService {
    @Resource
    private IuTabsMapper IuTabsMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public ResultVo listIuTabs() {
        /**
         * 1、从redis中获取tabs数据，判断是否为空
         * 2、如果不为空，直接返回给前端
         * 3、如果为空，添加双重检测锁，先从redis中查找tabs数据，判断是否为空
         * 4、如果为空，去数据库中查找tabs数据，否则去redis中查找tabs数据
         */
        ResultVo resultVo = null;
        try {
            String tabsJson = stringRedisTemplate.opsForValue().get("tabs");
            if (tabsJson != null && !"".equals(tabsJson)) {
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuTabs.class);
                List<IuTabs> tabs = objectMapper.readValue(tabsJson, javaType);
                resultVo=new ResultVo(ResponseStatus.success,"list success",tabs);
            }else{
                synchronized (this){
                    String json = stringRedisTemplate.opsForValue().get("tabs");
                    if(json==null){
                        Example example = new Example(IuTabs.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("status",0)
                                .andEqualTo("deleted",0);
                        example.orderBy("seq");
                        List<IuTabs> iuTabs = IuTabsMapper.selectByExample(example);
                        if(iuTabs!=null&&iuTabs.size()>0){
                            stringRedisTemplate.opsForValue().set("tabs",objectMapper.writeValueAsString(iuTabs),1, TimeUnit.DAYS);
                            resultVo=new ResultVo(ResponseStatus.success,"list success",iuTabs);
                        }else{
                            stringRedisTemplate.opsForValue().set("tabs","[]",10,TimeUnit.SECONDS);
                        }
                    }else{
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuTabs.class);
                        IuTabs tabs = (IuTabs) objectMapper.readValue(json, javaType);
                        resultVo=new ResultVo(ResponseStatus.success,"list success",tabs);
                    }

                }
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
            resultVo=new ResultVo(ResponseStatus.fail,"list JsonProcessingException",null);
        }
        return resultVo;
    }

    @Override
    public ResultVo listTabsToCollect() {
        ResultVo resultVo = null;
        try {
            String tabsJson = stringRedisTemplate.opsForValue().get("collects");
            if (tabsJson != null && !"".equals(tabsJson)) {
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuTabs.class);
                List<IuTabs> tabs = objectMapper.readValue(tabsJson, javaType);
                resultVo=new ResultVo(ResponseStatus.success,"list success",tabs);
            }else{
                synchronized (this){
                    String json = stringRedisTemplate.opsForValue().get("collects");
                    if(json==null){
                        Example example = new Example(IuTabs.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("status",0)
                                .andEqualTo("deleted",0)
                                .andEqualTo("isCollect",1);
                        example.orderBy("seq");
                        List<IuTabs> iuTabs = IuTabsMapper.selectByExample(example);
                        if(iuTabs!=null&&iuTabs.size()>0){
                            stringRedisTemplate.opsForValue().set("collects",objectMapper.writeValueAsString(iuTabs),1, TimeUnit.DAYS);
                            resultVo=new ResultVo(ResponseStatus.success,"list success",iuTabs);
                        }else{
                            stringRedisTemplate.opsForValue().set("collects","[]",10,TimeUnit.SECONDS);
                        }
                    }else{
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuTabs.class);
                        IuTabs tabs = (IuTabs) objectMapper.readValue(json, javaType);
                        resultVo=new ResultVo(ResponseStatus.success,"list success",tabs);
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
