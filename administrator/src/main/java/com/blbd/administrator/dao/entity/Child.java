package com.blbd.administrator.dao.entity;

import lombok.Data;

@Data
public class Child {
    private String id;
    private int score;
    private String username;
    private String password;
    private String name;
    private String grade;
    private String locate;
    private int duty;
    private int completedTasks;
}
