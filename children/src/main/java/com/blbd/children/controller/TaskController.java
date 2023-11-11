package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.dto.TaskDTO;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.dao.entity.TaskVolunteer;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.mapper.TaskVolunteerMapper;
import com.blbd.children.service.TaskService;
import com.blbd.children.service.TaskVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zxr
 * @since 2023-11-02
 */

@RestController
@RequestMapping("children/task")
public class TaskController {
    @Resource
    TaskMapper taskMapper;
    @Autowired
    TaskVolunteerMapper taskVolunteerMapper;
    @Autowired
    TaskVolunteerService taskVolunteerService;

    /**
     * 显示必做任务和选做任务,以及最高得分
     * @param grade
     * @return HttpResponseEntity
     */
    @GetMapping("/verifyGradeTask/{grade}")
    public HttpResponseEntity viewTaskInfo(@PathVariable String grade) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        LambdaUpdateWrapper<Task> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.setSql("complete_num = (SELECT COUNT(*) FROM task_child WHERE task_child.task_id = task.id AND task_child.is_completed = 1)");
        taskMapper.update(null, updateWrapper);


        //必做任务(本年级)
        List<Task> mustDoTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", grade)
                        .eq("is_must_do", 1)
        );
        //选做任务(本年级)
        List<Task> optionalTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .eq("grade", grade)
                        .eq("is_must_do", 0)
        );
        //选做任务(非本年级的所有任务)
        List<Task> differentGradeTasks = taskMapper.selectList(
                new QueryWrapper<Task>()
                        .ge("finish_time", new Date())
                        .ne("grade", grade)
        );

        //合并任务列表
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(mustDoTasks);
        tasks.addAll(optionalTasks);
        tasks.addAll(differentGradeTasks);

        //taskDTO:包含highestScore和task
        /*List<TaskDTO> taskDTOS = new ArrayList<>();

        for (Task task : tasks) {

            TaskDTO taskDTO = new TaskDTO();

            taskDTO.setTask(task);

            LambdaQueryWrapper<TaskVolunteer> volunteerWrapper = new LambdaQueryWrapper<>();
            volunteerWrapper.select(TaskVolunteer::getGetScore);
            volunteerWrapper.eq(TaskVolunteer::getTaskId, task.getId());
            volunteerWrapper.orderByDesc(TaskVolunteer::getGetScore);
            volunteerWrapper.last("LIMIT 1");

            List<TaskVolunteer> taskVolunteers = taskVolunteerMapper.selectList(volunteerWrapper);
            TaskVolunteer taskVolunteer = null;
            if (!taskVolunteers.isEmpty()) {
                taskVolunteer = taskVolunteers.get(0);
            }

            if (taskVolunteer != null) {
                Integer maxScore = taskVolunteer.getGetScore();
                taskDTO.setHighestScore(maxScore);
            } else{
                taskDTO.setHighestScore(0);
            }
            taskDTOS.add(taskDTO);
        }

        if (taskDTOS.isEmpty()){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有正在进行的任务");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(taskDTOS);
            httpResponseEntity.setMessage("查看任务的必做和选做,包含已完成人数");
        }*/

        if (tasks.isEmpty()){
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
    @PostMapping("/ViewCertainGradeTask")
    public HttpResponseEntity ViewCertainGradeTask(@RequestParam("grade") String grade) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<Task> tasks = taskMapper.selectList(Wrappers.<Task>lambdaQuery().eq(Task::getGrade, grade));
        if (tasks.isEmpty()){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("查询指定年级课程失败");
        }else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(tasks);
            httpResponseEntity.setMessage("查询指定年级课程成功");
        }
        return httpResponseEntity;
    }


}
