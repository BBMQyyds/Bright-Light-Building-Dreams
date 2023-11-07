package com.neu.administrator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.dto.VolunteerDto;
import com.neu.administrator.model.po.Task;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;

/**
 * @ClassName TaskService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 16:14
 * @Version 1.0
 */
public interface TaskService extends IService<Task> {
    void allocateTaskToVol(String childId, String taskId);

    PageResult<Task> searchTasks(PageParams pageParams,Task task);

    //新增或修改任务
    boolean saveTask(Task task);

    //发布任务
    boolean publishTask(Task task);

    //给孩子分配任务
    public void allocateTaskToChild(TaskDto taskDto);


    //给志愿者分配任务
    public void allocateHelpTaskToVol(VolunteerDto volunteerDto);
}
