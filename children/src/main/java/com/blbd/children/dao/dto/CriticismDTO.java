package com.blbd.children.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriticismDTO {
//    是否通过的状态
    private Integer isCorrected;
//    任务的名字
    private String name;
//    任务的图片地址
    private String taskPhoto;
//    任务的描述
    private String content;
//    提交的图片
    private String homeworkPhoto;
//    批改的评语
    private String comment;

    public CriticismDTO(Integer isCorrected, String name, String taskPhoto,String content, String homeworkPhoto) {
        this.isCorrected = isCorrected;
        this.name = name;
        this.taskPhoto = taskPhoto;
        this.content = content;
        this.homeworkPhoto = homeworkPhoto;
    }
}
