package com.scorpion.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IndexImg;
import com.scorpion.mapper.IndexImgMapper;
import com.scorpion.service.IndexImgService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2021/11/6
 */
@Service
public class IndexImgServiceImpl implements IndexImgService{
    @Resource
    private IndexImgMapper indexImgMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private ObjectMapper objectMapper= new ObjectMapper();
    @Override
    public ResultVo ListIndexImg() {
        try {
            //  1000个并发请求，请求轮播图
            String indexImgJson = stringRedisTemplate.opsForValue().get("indexImg");
            //  1000个请求查询到redis中的数据都是null
            if (indexImgJson != null) {
                //  如果从redis查询到轮播图数据，直接返回
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IndexImg.class);
                List<IndexImg> list = objectMapper.readValue(indexImgJson, javaType);
                return new ResultVo(ResponseStatus.success, "success", list);
            } else {
                //  1000个请求都会进入else
                //  （service类在spring容器中是单例的，1000个并发会启动1000个线程来处理，但是共用一个service实例）
                synchronized (this){
                    //  第二次查询redis
                    String Json = stringRedisTemplate.opsForValue().get("indexImg");
                    if(Json==null){
                        //  如果从redis中查询不到轮播图数据，从数据库中查询轮播图数据并存入redis中
                        //这1000个请求中，只有一个请求再次查询redis时依然为null
                        List<IndexImg> list = indexImgMapper.listIndexImg();
                        if (list!=null) {  //如果从数据库中查询到的数据不为空，则存入redis中，解决缓存穿透问题
                            //  将第一个请求查询到的数据存储到redis中，便于后面999个请求中redis中获取数据
                            stringRedisTemplate.opsForValue().set("indexImg", objectMapper.writeValueAsString(list),1, TimeUnit.DAYS);
                            return new ResultVo(ResponseStatus.success, "success", list);
                        }else{  //  如果从数据库中查到的数据为空，则存入一个非空的对象到redis中，并且设置过期时间，防止用户一直向redis中查询空的数据

                           stringRedisTemplate.opsForValue().set("indexImg", objectMapper.writeValueAsString("[]"),10, TimeUnit.SECONDS);
                        }
                    }else{
                        //  后面的请求从redis中获取数据
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IndexImg.class);
                        List<IndexImg> list = objectMapper.readValue(Json, javaType);
                        return new ResultVo(ResponseStatus.success, "success", list);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(ResponseStatus.fail, "fail", null);
    }
}
