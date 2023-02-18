package com.scorpion.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author scorpion
 * @date 2022/4/30
 */
@Configuration
public class BeanConfig {
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
