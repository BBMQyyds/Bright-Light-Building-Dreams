package com.blbd.children.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {

        //    每一条记录的唯一标识（taskChild）
        private String id;
        //    获得的积分值
        private Integer score;
        //    做的什么任务
        private String taskName;
        //     收入——学习任务    支出——积分商城
        private String kind;

}

