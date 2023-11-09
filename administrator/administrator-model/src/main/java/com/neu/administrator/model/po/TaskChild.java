package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("task_child")
public class TaskChild implements Serializable {

    private static final long serialVersionUID = 1L;

    private String childId;

    private String taskId;

    private Integer score;

    private LocalDateTime taskStartTime;

    private LocalDateTime taskFinishTime;

    private LocalDateTime taskEndTime;

    @TableField("is_completed")
    private Boolean completed;

    private Integer isCorrected;

    private String assignmentStage;

    private String homeworkPhoto;

    private LocalDateTime taskApproveTime;

    private String comment;


}
