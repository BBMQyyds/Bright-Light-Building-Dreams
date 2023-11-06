package com.blbd.children.service;

import com.blbd.children.dao.dto.ScoreDTO;
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

}
