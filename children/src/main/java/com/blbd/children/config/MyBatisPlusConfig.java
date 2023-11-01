package com.blbd.children.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/1 - 13:37
 */
@MapperScan("com.blbd.children.mapper")
@Configuration
@EnableTransactionManagement    //自动管理事务
public class MyBatisPlusConfig {
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //性能分析插件
    //把慢sql揪出来优化，不能让用户等
    @Bean
    @Profile({"dev","test"})//设置dev开发、test测试 环境开启  保证我们的效率
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100); //设置sql最大执行时间*ms，如果超过了则不执行
        performanceInterceptor.setFormat(true); //开启sql格式化
        return performanceInterceptor;
    }
}
