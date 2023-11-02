package com.blbd.children.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/1 - 13:37
 */
@MapperScan("com.blbd.children.mapper")
@Configuration
//@EnableTransactionManagement    //自动管理事务
public class MyBatisPlusConfig {

}
