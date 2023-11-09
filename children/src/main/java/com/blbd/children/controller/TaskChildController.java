package com.blbd.children.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.service.TaskChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @GetMapping("/count/{childId}")
    public ResponseEntity<Map<String, Object>> getTaskStats(@PathVariable String childId) {

//        LambdaQueryWrapper<TaskChild> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(TaskChild::getChildId, childId);

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
}
