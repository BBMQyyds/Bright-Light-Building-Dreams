package com.blbd.volunteer.dao.entity;
import lombok.Data;

@Data
public class LogEntity {
    private String logId;
    private Data logDate;
    private String logContent;
    private String logVolunteerId;
    private String logChildId;

}