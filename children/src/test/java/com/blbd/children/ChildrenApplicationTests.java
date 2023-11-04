package com.blbd.children;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskChildService;
import com.blbd.children.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    void loginChild(){
        //将输入的数据与数据库进行匹配，看是否存在
        Child child1 = childMapper.selectOne(Wrappers.<Child>lambdaQuery().eq(Child::getUsername, "user1").eq(Child::getPassword, "password1"));
        System.out.println(child1);
    }

    @Test
    void testSelectAllTasks() {
        taskMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void insert() {
        Task task = new Task();
        taskMapper.insert(task);
    }

    @Test
    void taskmustDoNot(){
        Child child = new Child();
        child.setGrade("D");
        List<Task> mustDoTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", child.getGrade())
                        .eq("is_must_do", 1)
        );
//        选做任务
        List<Task> optionalTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", child.getGrade())
                        .eq("is_must_do", 0)
        );

        List<Task> differentGradeTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .ne("grade", child.getGrade())
        );

        // 合并任务列表
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(mustDoTasks);
        System.out.println("mustDoTasks:" + mustDoTasks);
        System.out.println("-------------");
        tasks.addAll(optionalTasks);
        System.out.println("optionalTasks:" + optionalTasks);
        System.out.println("------------");
        tasks.addAll(differentGradeTasks);
        System.out.println("differentGradeTasks:" + differentGradeTasks);
        System.out.println("---------------");
        System.out.println("tasks" + tasks);
    }

    @Test
    void viewAllTask(){
        List<Task> tasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
        );
        System.out.println(tasks);
    }
}
