package com.neu.administrator;

import com.neu.administrator.service.TaskService;
import com.neu.base.model.message.AllocateTaskVolMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    void allocateTaskToVolTest(){
        AllocateTaskVolMessage allocateTaskVolMessage=new AllocateTaskVolMessage();
        allocateTaskVolMessage.setTaskId("4");
        allocateTaskVolMessage.setChildId("4");

        taskService.allocateTaskToVol(allocateTaskVolMessage);
    }
}
