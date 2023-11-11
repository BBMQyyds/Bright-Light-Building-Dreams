package com.blbd.children.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blbd.children.dao.entity.Task;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sq
 * @since 2023-11-02
 */
public interface TaskService extends IService<Task> {
    /**
     * 列表
     */
    public List<Task> getAllTaskList();

    /**
     * 增
     */
    public int addTask(Task entity);

    /**
     * 通过ID删除
     */
    public boolean deleteTaskById(String id);

    /**
     * 通过ID改
     */
    public int editTask(Task entity);

    /**
     * 通过ID查一个任务
     */
    public Task queryTaskById(String id);

    /**
     * 查询满足条件的任务列表
     */
    public List<Task> list(Wrapper queryWrapper);


    /**
     * 查询所有任务的最高得分
     */
    public List<Map<String, Object>> getMaxScoreForEachTask();

}
