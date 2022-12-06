package com.kindergarten.config;

import io.swagger.annotations.ApiOperation;
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
 * @author lxcecho 909231497@qq.com
 * @since 23:43 06-12-2022
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("学习要第一")
                .apiInfo(webApiInfo())
                .select()
                // 加了 ApiOperation 注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("com.kindergarten.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("幼稚园中心API文档")
                .description("幼稚园管理系统API文档中心")
                .version("1.0")
                .contact(new Contact("java", "https://kindergarten.com", "909231497@qq.com"))
                .build();
    }

}
