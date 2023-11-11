package com.blbd.children.dao.dto;

import com.blbd.children.dao.entity.Task;
import lombok.Data;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/10 14:24
 * @Version 1.0
 */
@Data
public class MyTaskDTO extends Task {
    private Integer is_corrected;
    private Task task;
}
