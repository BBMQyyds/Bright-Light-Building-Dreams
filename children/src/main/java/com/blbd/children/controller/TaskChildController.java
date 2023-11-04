package com.blbd.children.controller;


import com.blbd.children.dao.entity.Task;
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
//@Api(tags = "控制器-任务")
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


}

