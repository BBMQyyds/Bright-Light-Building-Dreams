package com.blbd.children.dao.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ScoreAddDTO {

    //    积分值
    private String num;
    //    获得积分的日期
    private Date date;
    //    任务名称
    private String taskName;
    //    类型
    private final String kind = "学习任务";
}