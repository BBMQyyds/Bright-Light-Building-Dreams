package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
     * 任务得分
     */
    private Integer score;

    /**
     * 任务开始时间
     */
    private Date taskStartTime;

    /**
     * 任务截止时间
     */
    private Date taskFinishTime;

    /**
     * 任务完成时间
     */
    private Date taskEndTime;

    /**
     * 是否已完成--任务已提交就算完成
     */
    private Boolean isCompleted;

    /**
     * 是否已批改
     */
    private Integer isCorrected;

    /**
     * 指派阶段
     */
    private String assignmentStage;
}
