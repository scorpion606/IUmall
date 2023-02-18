package com.scorpion.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2021/11/3
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行浏览器的预检请求
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        //校验token
        //1，判断响应头是否有token参数
        //2，解密token与加密的token比较判断是否相同
        if (token == null) {
            ResultVo resultVo = new ResultVo(ResponseStatus.LOGIN_FAIL,  "请先登录！", null);
            doResponse(response,resultVo);

        } else {
            //JWT解析token
            /*JwtParser parser = Jwts.parser();
            parser.setSigningKey("5201314xn");                                   //解析token的SigningKey必须和生成token时设置的密码一样
            try {
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);            //如果token正确（密码正确，有效期内）则正常执行，否则抛出异常
                return true;
            }catch(ExpiredJwtException e) {
                ResultVo resultVo = new ResultVo(ResponseStatus.LOGIN_EXPIRED, "登录过期,请重新登录!", null);
                doResponse(response,resultVo);
            }catch (UnsupportedJwtException e){
                ResultVo resultVo = new ResultVo(ResponseStatus.LOGIN_ILLEGAL, "Token不合法,请重新登录!", null);
                doResponse(response,resultVo);
            } catch (Exception e) {
                ResultVo resultVo = new ResultVo(ResponseStatus.LOGIN_FAIL, "请先登录！", null);
                doResponse(response,resultVo);
            }*/
            String tokenKey = RedisKey.token + token;
            if(stringRedisTemplate.hasKey(tokenKey)) {
                String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
                if (userJson == null) {
                    //  如果redis中的用户信息为空，代表用户未登录
                    ResultVo resultVo = new ResultVo(ResponseStatus.LOGIN_FAIL, "请先登录！", null);
                    doResponse(response, resultVo);
                } else {
                    //  如果redis中的用户信息不为空，代表用户已经登录，token续期
                    stringRedisTemplate.boundValueOps(RedisKey.token + token).expire(1, TimeUnit.DAYS);
                    return true;
                }
            }else{
                ResultVo resultVo=new ResultVo(ResponseStatus.LOGIN_EXPIRED,"token已过期，请重新登录！",null);
                doResponse(response,resultVo);
            }

        }
        return false;
    }
    private void doResponse(HttpServletResponse response,ResultVo resultVo) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String s = new ObjectMapper().writeValueAsString(resultVo);
        PrintWriter writer = response.getWriter();
        writer.print(s);
        writer.flush();
        writer.close();

    }
}
