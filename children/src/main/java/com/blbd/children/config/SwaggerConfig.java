//package com.blbd.children.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
///**
// * @author sq ♥ovo♥
// * @date 2023/11/1 - 15:31
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    /*//配置swagger的docket的bean实例
//    //没有set方法，只能通过构造器
//    //@Profile("prod")
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("blbd")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.blbd.children.controller"))
//                .build();
//    }
//
//
//    //配置swagger信息apiInfo
//    @Bean
//    public ApiInfo apiInfo(){
//        Contact contact = new Contact("sq", "https://github.com/shu-qian", "20216654@stu.neu.edu.cn");//作者信息
//
//        return new ApiInfo(
//                "儿童端swagger文档",
//                "明光筑梦儿童端swagger文档",
//                "1.0",
//                "https://github.com/BBMQyyds/Bright-Light-Building-Dreams",
//                contact,
//                "MIT License",
//                "https://opensource.org/licenses/MIT",
//                new ArrayList<>());
//    }*/
//
//}
