package com.neu.administrator.api;

import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.dto.VolunteerDto;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Task;
import com.neu.administrator.service.TaskService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "任务管理接口")
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @ApiOperation("发布学习任务")
    @PostMapping("/publish")
    public RestResponse<String> publishTasks(@RequestBody Task task){
        if(taskService.publishTask(task)){
            return RestResponse.success("发布学习任务成功");
        }
        //todo 成功失败逻辑
        return RestResponse.validfail("发布学习任务失败");
    }//RequestBody的作用是将前端传过来的json数据转换成java对象

    @ApiOperation("创建学习任务与编辑学习任务")
    @PostMapping("/create")
    public RestResponse<String> updateTasks(@RequestBody Task task){
       boolean flag=taskService.saveTask(task);
       if(flag){
           return RestResponse.success("操作成功");
       }
           return RestResponse.validfail("操作失败");
    }


    @ApiOperation("分配学习任务给儿童")
    @PostMapping("/assignChild")
    public RestResponse<String> assignTasksForChild(@RequestBody TaskDto taskDto ){
        taskService.allocateTaskToChild(taskDto);
        return RestResponse.success("分配学习任务成功");
    }

    @ApiOperation("删除学习任务")
    @PostMapping ("/delete")
    public RestResponse<String> deleteTask(@RequestBody Task task){
        boolean flag=taskService.removeById(task.getId());
        if (flag==true){
            return RestResponse.success("删除学习任务成功");
        }
        return RestResponse.validfail("删除学习任务失败");
    }


    @ApiOperation("查询学习任务")
    @PostMapping("/search")
    public RestResponse<PageResult> searchTasks(@RequestBody Task task , PageParams params){
        PageResult<Task> pageResult=taskService.searchTasks(params,task);
        return RestResponse.success(pageResult);
    }



    @ApiOperation("分配任务给志愿者")
    @PostMapping("/assignVol")
    public RestResponse<String> assignTasksForVolunteer(@RequestBody VolunteerDto volunteerDto){
        //todo 给儿童插一个志愿者id
        taskService.allocateHelpTaskToVol(volunteerDto);
        return RestResponse.success("分配成功");
    }




}
