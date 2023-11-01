package com.blbd.administrator.dao.entity;

import lombok.Data;

@Data
public class Volunteer {
    private String id;
    private String username;
    private String password;
    private String name;
    private String locate;
    private String organization;
    private int duty;
    private int correctedTasks;
}