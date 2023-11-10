package com.blbd.children.service;

import com.blbd.children.dao.dto.ScoreAddDTO;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 *  孩子-任务相关：
 *      查看已提交未批改任务
 *      查看已批改（已完成）任务
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
public interface TaskChildService extends IService<TaskChild> {
    /**
     * 查看已提交未批改任务--已提交任务
     */
    List<Task> getSubmittedUncorrectedTasksByChildId(String childId);

    /**
     * 查看已批改（已完成）任务--已完成任务
     */
    List<Task> getCorrectedTasks(String childId);

    /**
     * 获得当前孩子当前任务的作业图片名称
     */
    String selectHomeworkPhoto(String childId,String taskId);

    /**
     * 上传当前孩子当前任务的作业图片
     */
    public int addTaskChild(TaskChild taskChild);


    public TaskChild selectTaskChild(String childId, String taskId);
}
