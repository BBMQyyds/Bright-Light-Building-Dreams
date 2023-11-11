package com.blbd.children.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.dto.MyTaskDTO;
import com.blbd.children.dao.dto.TaskDTO;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.dao.entity.TaskVolunteer;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.mapper.TaskVolunteerMapper;
import com.blbd.children.service.TaskChildService;
import com.blbd.children.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  任务与孩子关联信息 前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */

@RestController
@RequestMapping("/children/task-child")
public class TaskChildController {
    @Autowired
    private TaskChildService taskChildService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskVolunteerMapper taskVolunteerMapper;

    //获取孩子的已提交未批改任务
    @GetMapping("/submitted-uncorrected/{childId}")
    public ResponseEntity<Map<String, Object>> submittedUncorrectedList(@PathVariable String childId) {
        List<Task> tasks = taskChildService.getSubmittedUncorrectedTasksByChildId(childId);

        Map<String, Object> response = new HashMap<>();

        if (tasks != null && !tasks.isEmpty()) {
            response.put("success", true);
            response.put("message", "该儿童已提交的未批改任务已成功检索");
            response.put("data", tasks);

            //创建一个 HTTP 200（OK）的成功响应，并将 response 对象作为响应体返回
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "该儿童没有已提交的未批改任务");
            response.put("data", null);

            //用于创建一个 HTTP 响应，状态码为 404（Not Found），表示未找到所请求的资源。
            //return ResponseEntity.notFound().build();

            //没有满足条件的数据不代表404
            return ResponseEntity.ok(response);
        }
    }

    //获取孩子的已批改任务
    @GetMapping("/corrected/{childId}")
    public ResponseEntity<Map<String,Object>> CorrectedList(@PathVariable String childId){
        List<Task> tasks = taskChildService.getCorrectedTasks(childId);

        HashMap<String, Object> response = new HashMap<>();

        if (tasks!= null && !tasks.isEmpty()){
            response.put("success",true);
            response.put("message","该儿童已提交的已批改任务已成功检索");
            response.put("data",tasks);

            return ResponseEntity.ok(response);
        } else {
          response.put("success",false);
          response.put("message", "该儿童没有已提交的已批改任务");
          response.put("data", null);

          return ResponseEntity.ok(response);
        }
    }

    /**
     * 待批改的任务数量
     * 已批改但未通过的任务数量
     * 已批改且已通过的任务数量
     * @param childId
     * @return
     */

    @GetMapping("/count/{childId}")
    public ResponseEntity<Map<String, Object>> getTaskStats(@PathVariable String childId) {


// 待批改的任务数量
        int pendingTasks = Math.toIntExact(taskChildService.lambdaQuery()
                .eq(TaskChild::getChildId, childId)
                .eq(TaskChild::getIsCorrected, 0)
                .count());

// 已批改但未通过的任务数量
        int notPassedTasks = Math.toIntExact(taskChildService.lambdaQuery()
                .eq(TaskChild::getChildId, childId)
                .eq(TaskChild::getIsCorrected, 1)
                .count());

// 已批改且已通过的任务数量
        int passedTasks = Math.toIntExact(taskChildService.lambdaQuery()
                .eq(TaskChild::getChildId, childId)
                .eq(TaskChild::getIsCorrected, 2)
                .count());


        Map<String, Integer> counts = new HashMap<>();
        counts.put("pendingTasks", pendingTasks);
        counts.put("notPassedTasks", notPassedTasks);
        counts.put("passedTasks", passedTasks);

        HashMap<String, Object> response = new HashMap<>();

        if (counts!= null && !counts.isEmpty()){
            response.put("success",true);
            response.put("message","待批改的任务数量，已批改但未通过的任务数量，已批改并且通过的任务数量统计成功");
            response.put("data",counts);

            return ResponseEntity.ok(response);
        } else {
            response.put("success",false);
            response.put("message", "无法统计：待批改的任务数量，已批改但未通过的任务数量，已批改并且通过的任务数量");
            response.put("data", null);

            return ResponseEntity.ok(response);
        }

    }

    /**
     * 显示待完成的所有任务
     * @param childId
     * @return
     */
    @GetMapping("/viewRemainingTasks/{childId}")
    public ResponseEntity<Map<String, Object>> viewRemainingTasks(@PathVariable("childId") String childId) {
        QueryWrapper<TaskChild> taskChildQueryWrapper = new QueryWrapper<>();
        taskChildQueryWrapper.eq("child_id", childId)
                .eq("is_completed", 1); // 过滤已完成的任务
        List<TaskChild> completedTasksList = taskChildService.list(taskChildQueryWrapper);

        QueryWrapper<Task> taskQueryWrapper = new QueryWrapper<>();
        List<Task> allTasksList = taskService.list(taskQueryWrapper);

        List<Task> remainingTasksList = new ArrayList<>(allTasksList);
        for (TaskChild completedTask : completedTasksList) {
            remainingTasksList.removeIf(task -> task.getId().equals(completedTask.getTaskId()));
        }
        List<TaskDTO> taskDTOS = new ArrayList<>();

        for (Task task : remainingTasksList) {

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



        for (Task task : remainingTasksList) {

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

        int remainingTasks = remainingTasksList.size();

        HashMap<String, Object> response = new HashMap<>();

        if (remainingTasks > 0) {
            response.put("success", true);
            response.put("message", "获取剩余任务成功");
            response.put("data", taskDTOS);
            response.put("tasks", remainingTasksList);
            response.put("num",remainingTasks);

            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "无剩余任务");
            response.put("data", null);

            return ResponseEntity.ok(response);
        }
    }
    /**
     *看我的任务
     */
    @GetMapping("/viewMyTasks/{childId}")
    public ResponseEntity<Map<String, Object>> viewMyTasks(@PathVariable("childId") String childId) {

        QueryWrapper<TaskChild> taskChildQueryWrapper = new QueryWrapper<>();
        taskChildQueryWrapper.eq("child_id", childId)
                .eq("is_completed", 1);

        List<TaskChild> completedTasksList = taskChildService.list(taskChildQueryWrapper);

        List<String> taskIds = completedTasksList.stream()
                .map(TaskChild::getTaskId)
                .collect(Collectors.toList());

        List<MyTaskDTO> taskList = new ArrayList<>();

        if (!taskIds.isEmpty()) {
            QueryWrapper<Task> taskQueryWrapper = new QueryWrapper<>();
            taskQueryWrapper.in("id", taskIds);

            List<Task> tasks = taskService.list(taskQueryWrapper);

            Map<String, Task> taskMap = tasks.stream()
                    .collect(Collectors.toMap(Task::getId, task -> task));

            taskList = completedTasksList.stream()
                    .map(taskChild -> {
                        MyTaskDTO myTaskDTO = new MyTaskDTO();
                        BeanUtils.copyProperties(taskChild, myTaskDTO);

                        Task task = taskMap.get(taskChild.getTaskId());
                        if (task != null) {
                            myTaskDTO.setIs_corrected(taskChild.getIsCorrected());
                            BeanUtils.copyProperties(task, myTaskDTO);
                        }

                        return myTaskDTO;
                    })
                    .collect(Collectors.toList());
        }

        HashMap<String, Object> response = new HashMap<>();
        if (taskList.size() != 0) {
            response.put("success", true);
            response.put("message", "获取我的任务成功");
            response.put("data", taskList);
            response.put("size", taskList.size());
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "无我的任务");
            response.put("data", null);

            return ResponseEntity.ok(response);
        }
    }
}
