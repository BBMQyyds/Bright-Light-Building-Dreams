package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * 显示必做任务和选做任务
     * @param grade
     * @return HttpResponseEntity
     */
    @GetMapping("/verifyGradeTask/{grade}")
    public HttpResponseEntity viewTaskInfo(@PathVariable String grade) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        LambdaUpdateWrapper<Task> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.setSql("complete_num = (SELECT COUNT(*) FROM task_child WHERE task_child.task_id = task.id AND task_child.is_completed = 1)");
        taskMapper.update(null, updateWrapper);

//        必做任务(本年级)
        List<Task> mustDoTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", grade)
                        .eq("is_must_do", 1)
        );
//        选做任务(本年级)
        List<Task> optionalTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", grade)
                        .eq("is_must_do", 0)
        );
//        选做任务(非本年级的所有任务)
        List<Task> differentGradeTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .ne("grade", grade)
        );

//  合并任务列表
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(mustDoTasks);
        tasks.addAll(optionalTasks);
        tasks.addAll(differentGradeTasks);
        if (tasks == null){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有正在进行的任务");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(tasks);
            httpResponseEntity.setMessage("查看任务的必做和选做,包含已完成人数");
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

    @GetMapping("/QueryOneTask/{id}")
    public HttpResponseEntity QueryOneTask(@PathVariable("id") String id) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        Task task = taskMapper.selectOne(Wrappers.<Task>lambdaQuery().eq(Task ::getId, id));
        if (task.equals("")){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("查询课程详细信息失败");
        }else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(task);
            httpResponseEntity.setMessage("查询课程的详细信息成功");
        }
        return httpResponseEntity;
    }

}
