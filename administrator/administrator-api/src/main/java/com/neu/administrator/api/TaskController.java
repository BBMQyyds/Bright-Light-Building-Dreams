package com.neu.administrator.api;

import com.neu.administrator.model.dto.TaskDto;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

@Api(value = "任务管理接口")
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @ApiOperation("发布学习任务")
    @PostMapping("/publish")
    public RestResponse<String> publishTasks(@RequestBody TaskDto taskDto){
        //todo 成功失败逻辑
        return RestResponse.success("发布学习任务成功");
    }

    @ApiOperation("创建学习任务与编辑学习任务")
    @PostMapping("/create")
    public RestResponse<String> updateTasks(@RequestBody TaskDto taskDto,@RequestParam("taskId") Integer taskId){
        //todo ...
        //传入的任务id进行判断

        //如果id在数据库中不存在，则保存内容存入数据库

        //如果id在数据库中已经存在，则更新任务的内容并且更新数据库
        return RestResponse.success("操作成功成功");
    }


    @ApiOperation("分配学习任务")
    @GetMapping("/assign")
    public RestResponse<String> assignTasks(@RequestBody TaskDto taskDto , @RequestParam("userId") Integer userId){
        //todo
        //判断任务id是否存在
        //如果任务不存在则返回报错信息
        //如果任务id存在则进行任务分配
        //从taskDto里获取任务的id，修改任务id，将其分配给使用者，修改数据库
        return RestResponse.success("分配学习任务成功");
    }






}
