package com.neu.administrator.api;

import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.po.Task;
import com.neu.administrator.model.po.TaskChild;
import com.neu.administrator.model.po.TaskVolunteer;
import com.neu.administrator.service.TaskChildService;
import com.neu.administrator.service.TaskVolunteerService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TaskChildController
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 10:54
 * @Version 1.0
 */
@Api(value = "儿童任务管理接口")
@Slf4j
@RestController
@RequestMapping("/taskChild")
public class TaskChildController {
    @Autowired
    private TaskVolunteerService taskVolunteerService;


    @Autowired
    private TaskChildService taskChildService;

    @ApiOperation("查询儿童任务（以完成，未批改）")
    @PostMapping("/search")
    public RestResponse<PageResult> searchTasks(@RequestBody TaskDto taskDto, PageParams params) {
        PageResult<TaskChild> pageResult = taskChildService.searchTasks(taskDto, params);
        return RestResponse.success(pageResult);
    }


    @ApiOperation("分配儿童已完成任务给志愿者")
    @PostMapping("/assign")
    public RestResponse assignTask(@RequestBody TaskVolunteer taskVolunteer){
        if(taskVolunteerService.assignTask(taskVolunteer)){
            return RestResponse.success("重新分配任务成功");
        }
        return RestResponse.validfail("重新分配任务失败");
    }


}
