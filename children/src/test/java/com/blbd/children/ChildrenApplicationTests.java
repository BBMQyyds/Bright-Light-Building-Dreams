package com.blbd.children;

import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChildrenApplicationTests {

    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskService taskService;

    @Test
    void contextLoads() {
        List<Child> childrenList = childMapper.selectList(null);

        childrenList.forEach(System.out::println);
    }

    @Test
    void testSelectAllTasks() {
        taskMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void testSelectAllTasks2() {
        taskService.list().forEach(System.out::println);
    }

}
