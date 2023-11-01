package com.blbd.administrator.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskChild {
    private String childId;
    private String taskId;
    private int score;
    private Date taskStartTime;
    private Date taskFinishTime;
    private Date taskEndTime;
    private boolean isCompleted;
    private boolean isCorrected;
    private String assignmentStage;
}
