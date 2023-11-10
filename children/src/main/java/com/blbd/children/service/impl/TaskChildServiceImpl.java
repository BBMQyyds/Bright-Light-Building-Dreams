package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sq
 * @since 2023-11-01
 *
 * 注意数据库认为已提交即已完成
 */
@Service
public class TaskChildServiceImpl extends ServiceImpl<TaskChildMapper, TaskChild> implements TaskChildService {
    @Autowired
    private TaskChildMapper taskChildMapper;

    @Autowired
    private TaskMapper taskMapper;


    /**
     * 查看当前孩子的已提交未批改任务
     */
    @Override
    public List<Task> getSubmittedUncorrectedTasksByChildId(String childId) {
        HashMap<String, Object> map = new HashMap<>();

        //自定义要查询的
        map.put("child_id", childId);
        map.put("is_completed", 1);
        map.put("is_corrected", 0);

        //查询 TaskChild 表中符合条件的记录
        List<TaskChild> taskChildList = taskChildMapper.selectByMap(map);

        //获取 TaskChild 表中的 taskId 列表
        /**
         * 使用 Java 8 中的 Stream API 来完成以下操作：
         * taskChildList.stream(): 它将 taskChildList 转换为一个流（Stream），这允许你对列表中的元素进行操作。
         * map(TaskChild::getTaskId): 在流中，map 操作将应用于流中的每个元素。在这里，我们使用 TaskChild::getTaskId，这表示我们将调用 TaskChild 类的 getTaskId 方法，以从每个 TaskChild 对象中获取 taskId。
         * collect(Collectors.toList()): 最后，collect 操作将流中的元素收集到一个列表中。这一行代码的结果是，它创建了一个 taskIds 列表，其中包含了 taskChildList 中每个 TaskChild 对象的 taskId。
         */
        List<String> taskIds = taskChildList.stream().map(TaskChild::getTaskId).collect(Collectors.toList());

        if (taskIds.isEmpty()) {
            return new ArrayList<>();   // 如果 taskIds 为空，直接返回空列表
        }

        //使用获取的 taskId 列表查询 Task 表中的任务
        QueryWrapper<Task> taskQueryWrapper = new QueryWrapper<>();
        taskQueryWrapper.in("id", taskIds);
        List<Task> tasks = taskMapper.selectList(taskQueryWrapper);

        return tasks;
    }

    /**
     * 查看当前孩子的已批改（已完成）任务--已完成任务
     */
    @Override
    public List<Task> getCorrectedTasks(String childId) {
        /*
        HashMap<String, Object> map = new HashMap<>();

        //自定义要查询的
        map.put("child_id", childId);
        map.put("is_corrected", 2);
        List<TaskChild> taskChildList = taskChildMapper.selectByMap(map);
        */

        QueryWrapper<TaskChild> wrapper = new QueryWrapper<>();

        wrapper.eq("child_id",childId);
        wrapper.in("is_corrected",Arrays.asList(1, 2));

        List<TaskChild> taskChildList = taskChildMapper.selectList(wrapper);

        List<String> taskIds = taskChildList.stream().map(TaskChild::getTaskId).collect(Collectors.toList());

        if (taskIds.isEmpty()) {
            return new ArrayList<>();
        }

        QueryWrapper<Task> taskQW = new QueryWrapper<>();
        taskQW.in("id", taskIds);
        List<Task> tasks = taskMapper.selectList(taskQW);

        return tasks;
    }

    /**
     * 获得当前孩子当前任务的作业图片名称
     */
    @Override
    public String selectHomeworkPhoto(String childId, String taskId) {
        QueryWrapper<TaskChild> wrapper = new QueryWrapper<>();

        wrapper.eq("child_id",childId);
        wrapper.eq("task_id",taskId);

        TaskChild taskChild = taskChildMapper.selectOne(wrapper);

        return taskChild.getHomeworkPhoto();
    }

    /**
     * 上传当前孩子当前任务的作业图片,即提交作业
     * 只需要传孩子ID,任务ID,作业图片名
     */
    @Override
    public int addTaskChild(TaskChild taskChild) {
        int result = taskChildMapper.insert(taskChild);

        return result;
    }

    /**
     * 联合主键查询唯一TaskChild
     */
    @Override
    public TaskChild selectTaskChild(String childId, String taskId) {
        QueryWrapper<TaskChild> wrapper = new QueryWrapper<>();
        wrapper.eq("child_id",childId)
                .eq("task_id",taskId);

        TaskChild taskChild = taskChildMapper.selectOne(wrapper);

        return taskChild;
    }

}
