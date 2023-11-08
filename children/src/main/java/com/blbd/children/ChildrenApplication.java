package com.blbd.children;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描mapper包下的所有接口
//@MapperScan("com.blbd.children.mapper")
@SpringBootApplication
public class ChildrenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChildrenApplication.class, args);

    }

}
