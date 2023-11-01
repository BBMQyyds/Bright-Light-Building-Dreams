package com.blbd.administrator.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private String id;
    private int score;
    private String content;
    private Date startTime;
    private Date finishTime;
    private String video;
    private String subject;
    private String grade;
    private String status;
    private boolean isMustDo;
}
