package com.scorpion.config;

import com.scorpion.interceptor.CheckTokenInterceptor;
import com.scorpion.interceptor.KeepTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author scorpion
 * @date 2021/11/3
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private CheckTokenInterceptor checkTokenInterceptor;

    @Resource
    private KeepTokenInterceptor keepTokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
                .addPathPatterns("/cart/**")
                .addPathPatterns("/userAddress/**")
                .addPathPatterns("/order/**")
                .addPathPatterns("/user/checkToken")
                .addPathPatterns("/user/getWxUserInfo")
                .addPathPatterns("/user/updateUserInfo")
                .addPathPatterns("/user/logout")
                .addPathPatterns("/collect/**")
                .addPathPatterns("/iuFootPrint/**")
                .addPathPatterns("/iuFeedBack/**");
        registry.addInterceptor(keepTokenInterceptor).addPathPatterns("/**");
    }
}
