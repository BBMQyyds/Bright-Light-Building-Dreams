package com.neu.administrator;

import com.neu.administrator.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName AllocateTaskServiceTests
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 17:12
 * @Version 1.0
 */
@SpringBootTest
public class TaskServiceTests {
    @Autowired
    TaskService taskService;

    @Test
    void allocateTaskToVolTest(){
        taskService.allocateTaskToVol("1","2");
    }
}
