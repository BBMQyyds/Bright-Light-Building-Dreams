package com.blbd.volunteer.dao.entity;
import lombok.Data;

import java.util.Date;

@Data
public class LogEntity {
    private String logId;
    private Date logDate;
    private String logContent;
    private String logVolunteerId;
    private String logChildId;

}