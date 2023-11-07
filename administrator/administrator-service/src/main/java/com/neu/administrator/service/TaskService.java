package com.neu.administrator.service;

import com.neu.base.model.message.AllocateTaskVolMessage;

/**
 * @ClassName TaskService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 16:14
 * @Version 1.0
 */
public interface TaskService {
    void allocateTaskToVol(AllocateTaskVolMessage allocateTaskVolMessage);
}
