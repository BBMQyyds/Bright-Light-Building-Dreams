package com.blbd.administrator.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskVolunteer {
    private String volunteerId;
    private String childId;
    private String taskId;
    private Date approvalStartTime;
    private Date approvalFinishTime;
    private Date approvalEndTime;
    private boolean isCompletedApproval;
    private String approvalComments;
}