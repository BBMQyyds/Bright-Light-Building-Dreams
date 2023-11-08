package com.neu.administrator.model.po;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

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


}
