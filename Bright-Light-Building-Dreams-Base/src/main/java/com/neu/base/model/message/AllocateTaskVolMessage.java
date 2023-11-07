package com.neu.base.model.message;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName allocateTaskVolMessage
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 21:13
 * @Version 1.0
 */
@Data
public class AllocateTaskVolMessage {
    private String childId;

    private String taskId;

    private LocalDateTime approvalStartTime;

    private LocalDateTime approvalFinishTime;

    private LocalDateTime approvalEndTime;
}
