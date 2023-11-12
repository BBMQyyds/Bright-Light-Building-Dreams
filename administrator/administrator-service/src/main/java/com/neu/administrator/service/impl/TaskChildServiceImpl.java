package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.TaskChild;
import com.neu.administrator.service.TaskChildService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TaskChildServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 11:08
 * @Version 1.0
 */
@Service
public class TaskChildServiceImpl implements TaskChildService {

    @Autowired
    private TaskChildMapper taskChildMapper;
    @Override
    public PageResult<TaskChild> searchTasks(TaskDto taskDto, PageParams params) {
        Long pageNo = params.getPageNo();
        Long pageSize = params.getPageSize();

        String taskId = taskDto.getTaskId();

        //查询儿童任务，要求儿童完成任务，但是没有被志愿者批改
        List<TaskChild> taskChildren = taskChildMapper.searchTasks(taskId, true, false, pageNo, pageSize);

        //查询儿童任务的总数
        Long total = taskChildMapper.searchTasksCount(taskId, true, false);
        return new PageResult<>(taskChildren, total, pageNo, pageSize);


    }
}
