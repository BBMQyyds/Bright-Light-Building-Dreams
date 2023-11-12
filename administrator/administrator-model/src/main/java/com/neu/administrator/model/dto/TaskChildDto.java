package com.neu.administrator.model.dto;

import com.neu.administrator.model.po.TaskChild;
import lombok.Data;

/**
 * @ClassName TaskChildDto
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 17:09
 * @Version 1.0
 */
@Data
public class TaskChildDto extends TaskChild {
    private String childName;
    private String taskName;
    private String content;
}
