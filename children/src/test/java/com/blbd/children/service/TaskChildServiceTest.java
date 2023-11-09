package com.blbd.children.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/4 - 0:27
 */
@SpringBootTest
public class TaskChildServiceTest {
    @Autowired
    private TaskChildService taskChildService;

    /**
     * 测试查看当前孩子的已提交未批改任务--
     */
    @Test
    public void testGetSubmittedUncorrectedTasks() {
        taskChildService.getSubmittedUncorrectedTasksByChildId("3").forEach(System.out::println);
    }

    /**
     * 测试查看当前孩子的已批改（已完成）任务
     */
    @Test
    public void testGetCorrectedTasks() {
        taskChildService.getCorrectedTasks("2").forEach(System.out::println);
    }
}
