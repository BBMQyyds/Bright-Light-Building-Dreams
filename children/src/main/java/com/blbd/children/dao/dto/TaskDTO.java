package com.blbd.children.dao.dto;

import com.blbd.children.dao.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/10 17:11
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer highestScore;
    private Task task;
}
