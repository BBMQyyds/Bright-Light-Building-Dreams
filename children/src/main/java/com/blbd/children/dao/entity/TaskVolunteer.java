package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
@TableName("task_volunteer")
public class TaskVolunteer {
    private String volunteerId;
    private String childId;
    private String taskId;
    private Date approvalStartTime;
    private Date approvalFinishTime;
    private Date approvalEndTime;
    private byte isCompletedApproval;
    private String approvalComments;
    private String homeworkPhoto;
    private String taskPhoto;
    private String childName;
    private String taskName;
    private String taskVideo;
    private Integer getScore;
}
