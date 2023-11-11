package com.blbd.children.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/11 - 14:27
 */
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    /**
     * 测试查看当前孩子的已提交未批改任务--
     */
    @Test
    public void testgetMaxScoreForEachTask() {
        taskService.getMaxScoreForEachTask().forEach(System.out::println);
    }

}
