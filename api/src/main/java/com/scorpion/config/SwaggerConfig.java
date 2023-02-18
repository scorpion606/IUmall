package com.scorpion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger会帮助我们生成接口规范文档
 * 1, 配置生成的文档信息
 * 2，配置生成规则
 */

/**
 * @author scorpion
 * @date 2021/10/16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        //设置接口文档的规范为DocumentationType.SWAGGER_2
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        //如何获取一个接口/抽象类的对象
        //new接口，需要在构造器后{}实现接口中的所有抽象方法
        //new子类/实现类
        //工厂模式
        ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();
        //设置文档的封面信息信息
        apiInfoBuilder.title("《乐购商城》后端接口规范")
                .description("此文档详细说明了乐购商城项目后端接口规范")
                .version("1.0.1")
                .contact(new Contact("scorpion","https://scorpion.com","2625618158@qq.com"));
        ApiInfo apiInfo=apiInfoBuilder.build();
        docket.apiInfo(apiInfo)
                .select()
                //设置要扫描接口的包
                .apis(RequestHandlerSelectors.basePackage("com.scorpion"))
                //设置扫描接口
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

}
