package com.scorpion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 扫描mapper下的mapper包
 */
@MapperScan("com.scorpion.mapper")
@SpringBootApplication
//开启quartz定时任务
@EnableScheduling
/**
 * @author scorpion
 */
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
