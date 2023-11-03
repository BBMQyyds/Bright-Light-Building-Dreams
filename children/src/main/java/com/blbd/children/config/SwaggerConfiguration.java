//package com.blbd.children.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
///**
// * @author sq ♥ovo♥
// * @date 2023/11/3 - 12:00
// */
////swagger接口文档的配置
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /**
//         *  /**表示所有的请求路径都将被映射到指定的资源路径中。
//         */
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/META-INF/resources/");  // 自己的配置
//        registry.addResourceHandler("/doc.html")  // 配置访问路径
//                .addResourceLocations("classpath:/META-INF/resources/");  // 添加Swagger的页面资源
//    }
//
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                // 分组名称
//                .groupName("儿童端开发的系统接口测试文档")
//                .select()
//                //这里标注控制器的位置
//                .apis(RequestHandlerSelectors.basePackage("com.blbd.children.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * api信息
//     * @return api对象信息
//     */
//    private ApiInfo apiInfo()   {
//        return new ApiInfoBuilder()
//                .title("儿童端开发的系统接口测试文档")  // 标题
//                .description("儿童端接口文档")  // 简介
//                .termsOfServiceUrl("https://github.com/BBMQyyds/Bright-Light-Building-Dreams") // Swagger API文档中的一个可选配置项，用于指定API服务的服务条款URL。
//                .contact(new Contact("sq","https://github.com/shu-qian","20216654@stu.neu.edu.cn")) //作者信息
//                .version("1.0")
//                .build();
//    }
//}
