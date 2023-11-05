package com.neu.administrator.listener;

import com.neu.administrator.constants.MqConstants;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.service.AdministratorInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Mq练手，自己监听自己
@Component
public class ChildListener {
    @Autowired
    private AdministratorInfoService administratorInfoService;


    @RabbitListener(queues= MqConstants.CHILD_INSERT_QUEUE)
    public void listenChildInsert(Child child){
        //save
        administratorInfoService.saveById(child);
    }

    @RabbitListener(queues=MqConstants.CHILD_DELETE_QUEUE)
    public void listenChildDelete(Child child){
        //delete
        administratorInfoService.removeById(child.getId());
    }



}
