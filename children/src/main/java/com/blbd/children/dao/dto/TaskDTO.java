package com.blbd.children.dao.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.blbd.children.dao.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
