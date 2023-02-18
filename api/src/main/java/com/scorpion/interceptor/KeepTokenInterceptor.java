package com.scorpion.interceptor;

import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2022/4/30
 */
@Component
public class KeepTokenInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token!=null){
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            if(userJson!=null){
                //  token续期
                stringRedisTemplate.boundValueOps(RedisKey.token+token).expire(1, TimeUnit.DAYS);
            }
        }
        return true;
    }
}
