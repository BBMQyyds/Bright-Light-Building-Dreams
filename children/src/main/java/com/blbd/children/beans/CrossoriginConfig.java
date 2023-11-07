package com.blbd.children.beans;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@Configuration
public class CrossoriginConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        CorsConfiguration corsConfig = new CorsConfiguration();
        // cors配置
        // 后端服务器（http://localhost:8182）为资源提供方，AllowedOrigins可配置哪些网站可以获取我的资源
        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost"));
        //corsConfig.setAllowedOrigins(Arrays.asList("*"));
        // 预检请求的响应中有效
        corsConfig.setAllowedMethods(Arrays.asList("GET","POST"));
        corsConfig.setAllowedHeaders(Arrays.asList("Content-Type"));
        //corsConfig.setMaxAge(Duration.ofHours(1L));
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfig);
        registrationBean.setFilter(new CorsFilter(source));
        registrationBean.setOrder(-1);
        return registrationBean;
    }
}
