package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zxr
 * @since 2023-11-02
 */
@RestController
@RequestMapping("children/task")
public class TaskController {
    @Resource
    TaskMapper taskMapper;

    /**
     * 展示所有任务
     * @return
     */
    @RequestMapping("/showAll")
    public HttpResponseEntity showAll(){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<Task> tasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
        );
        if (tasks.size() == 0){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有正在进行的任务");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(tasks);
            httpResponseEntity.setMessage("查看所有时效的任务");
        }
        return httpResponseEntity;
    }

    /**
     * 显示必做任务
     * @param child
     * @return
     */
    @RequestMapping("/verifyGradeTask")
    public HttpResponseEntity viewTaskInfo(@RequestParam Child child){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
//        必做任务(本年级)
        List<Task> mustDoTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", child.getGrade())
                        .eq("is_must_do", 1)
        );
////        选做任务(本年级)
//        List<Task> optionalTasks = taskMapper.selectList(
//                new QueryWrapper<Task>()
//                        .ge("finish_time", new Date())
//                        .eq("grade", child.getGrade())
//                        .eq("is_must_do", 0)
//        );
////        选做任务(非本年级的所有任务)
//        List<Task> differentGradeTasks = taskMapper.selectList(
//                new QueryWrapper<Task>()
//                        .ge("finish_time", new Date())
//                        .ne("grade", child.getGrade())
//        );

//  合并任务列表
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(mustDoTasks);
//        tasks.addAll(optionalTasks);
//        tasks.addAll(differentGradeTasks);
        if (tasks == null){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有正在进行的任务");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(tasks);
            httpResponseEntity.setMessage("查看任务的必做和选做");
        }
        return httpResponseEntity;
    }
/**
 * 模糊查找名称
 */
    @RequestMapping("/searchTask")
    public HttpResponseEntity searchTask(@RequestParam("subject") String subject){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<Task> tasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .like("subject", "%" + subject + "%")
        );
        if(tasks.size() == 0){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有匹配条件的搜索结果");
        }else{
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(tasks);
            httpResponseEntity.setMessage("查看模糊查询的结果");
        }
        return httpResponseEntity;
    }
}
