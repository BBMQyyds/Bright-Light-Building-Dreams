package com.blbd.volunteer;

import com.blbd.volunteer.dao.VolunteerEntityMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描mapper包下的所有接口
@MapperScan("com.blbd.volunteer.dao")
@SpringBootApplication
public class VolunteerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteerApplication.class, args);
    }

}
