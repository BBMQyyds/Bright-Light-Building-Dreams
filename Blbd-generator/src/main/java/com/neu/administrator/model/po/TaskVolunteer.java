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
@TableName("task_volunteer")
public class TaskVolunteer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String volunteerId;

    private String childId;

    private String taskId;

    private LocalDateTime approvalStartTime;

    private LocalDateTime approvalFinishTime;

    private LocalDateTime approvalEndTime;

    @TableField("is_completed_approval")
    private Boolean completedApproval;

    private String approvalComments;

    private String homeworkPhoto;

    private String taskPhoto;

    private String childName;

    private String taskName;


}
