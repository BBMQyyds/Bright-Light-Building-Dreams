package com.neu.administrator.service;

import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.po.TaskChild;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;

/**
 * @ClassName TaskChildService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 10:57
 * @Version 1.0
 */
public interface TaskChildService {
    PageResult<TaskChild>  searchTasks(TaskDto taskDto, PageParams params);
}
