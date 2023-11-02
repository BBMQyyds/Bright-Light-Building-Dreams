package com.blbd.volunteer.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskEntity {
    private String id;
    private int score;
    private Date startTime;
    private Date finishTime;
    private String video;
    private String subject;
    private String grade;
    private String status;
    private byte isMustDo;
    private String content;
    private String name;
    private String taskPhoto;

}