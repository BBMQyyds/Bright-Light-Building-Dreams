package com.neu.administrator.listener;

import com.neu.administrator.constants.MqConstants;
import com.neu.administrator.service.TaskService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TaskListener
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 15:37
 * @Version 1.0
 */
@Component
public class TaskListener {

    @Autowired
    private TaskService taskService;


    @RabbitListener(queues = MqConstants.TASK_VOL_ALLOCATE_QUEUE)
    void listenTaskVolunteerAllocate(String childId,String taskId){
            taskService.allocateTaskToVol(childId,taskId);
    }


}
