package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */

@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("task_child")
@Data
public class TaskChild implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 孩子ID，复合主键，外键
     */
//    @TableId
    private String childId;

    /**
     * 任务ID，复合主键，外键
     */
//    @TableId
    private String taskId;

    /**
     * 任务对应的积分，由任务ID查出来
     */
    private Integer score;

    /**
     * 任务开始时间，由任务ID查出来
     */
    private Date taskStartTime;

    /**
     * 任务完成时间，提交任务（上传任务图片时自动创建）
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date taskFinishTime;

    /**
     * 任务截止时间，由任务ID查出来
     */
    private Date taskEndTime;

    /**
     * 是否已完成--任务已提交就算完成,插入时和更新时自动为1
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Boolean isCompleted;

    /**
     * 是否已批改，插入和更新时初始为0,未批改
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer isCorrected;

    /**
     * 指派阶段，插入和更新时初始为1
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String assignmentStage;

    /**
     * 孩子提交的作业图片的地址
     */
    private String homeworkPhoto;

    /**
     * 志愿者对作业的评价，插入和更新时初始为null
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String comments;

    /**
     * 作业审批通过时间，插入和更新时初始为null
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date taskApproveTime;
}
