package com.blbd.children.controller;


import com.blbd.children.dao.entity.Task;
import com.blbd.children.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-02
 */
@RestController
@RequestMapping("/children/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public List<Task> getTaskList(){
        return taskService.list();
    }

}

