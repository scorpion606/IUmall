package com.scorpion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author scorpion
 * @date 2022/3/22
 */
/*
* 解决前后端跨域问题
* */
@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","POST","HEAD","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
