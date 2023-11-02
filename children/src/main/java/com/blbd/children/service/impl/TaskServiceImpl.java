package com.blbd.children.service.impl;

import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sq
 * @since 2023-11-02
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
