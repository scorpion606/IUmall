package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IuNavigation;
import com.scorpion.mapper.IuNavigationMapper;
import com.scorpion.service.IuNavigationService;
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
public class IuNavigationServiceImpl implements IuNavigationService {
    @Resource
    private IuNavigationMapper iuNavigationMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public ResultVo listNavigation(int parentId) {
        ResultVo resultVo=null;
        try {
            String navigationJson = stringRedisTemplate.opsForValue().get("navigation");
            if (navigationJson != null && !"".equals(navigationJson)) {
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuNavigation.class);
                List<IuNavigation> navigation = objectMapper.readValue(navigationJson, javaType);
                resultVo=new ResultVo(ResponseStatus.success,"list success",navigation);
            }else{
                String json = stringRedisTemplate.opsForValue().get("navigation");
                synchronized (this){
                    if(json==null){
                        Example example = new Example(IuNavigation.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("status",0)
                                .andEqualTo("deleted",0)
                                .andEqualTo("parentId",parentId);
                        example.orderBy("seq").asc();
                        List<IuNavigation> iuNavigations = iuNavigationMapper.selectByExample(example);
                        if(iuNavigations!=null&&iuNavigations.size()>0){
                            stringRedisTemplate.opsForValue().set("navigation",objectMapper.writeValueAsString(iuNavigations));
                            resultVo=new ResultVo(ResponseStatus.success,"list success",iuNavigations);
                        }else{
                            stringRedisTemplate.opsForValue().set("navigation","[]",10, TimeUnit.SECONDS);
                        }
                    }else{
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IuNavigation.class);
                        List<IuNavigation> navigation = objectMapper.readValue(json, javaType);
                        resultVo=new ResultVo(ResponseStatus.success,"list success",navigation);
                    }
                }
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return resultVo;
    }
}
