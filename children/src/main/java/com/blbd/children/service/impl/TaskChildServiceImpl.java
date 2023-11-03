package com.blbd.children.service.impl;

import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
@Service
public class TaskChildServiceImpl extends ServiceImpl<TaskChildMapper, TaskChild> implements TaskChildService {
    @Autowired
    private TaskMapper taskMapper;

    public List<Task> getTaskList(){
        return taskMapper.selectList(null);
    }

}
