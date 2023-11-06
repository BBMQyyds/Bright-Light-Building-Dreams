package com.neu.administrator.listener;

import com.neu.administrator.constants.MqConstants;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.AdministratorInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName VolListener
 * @Description TODO
 * @Author CY
 * @Date 2023/11/5 21:39
 * @Version 1.0
 */
@Component
public class VolListener {
    @Autowired
    private AdministratorInfoService administratorInfoService;


    @RabbitListener(queues= MqConstants.VOL_INSERT_QUEUE)
    public void listenChildInsert(Volunteer volunteer){
        //save
        administratorInfoService.saveVolunteerByIdEs(volunteer);
    }

    @RabbitListener(queues=MqConstants.VOL_DELETE_QUEUE)
    public void listenChildDelete(String volId){
        //delete
        administratorInfoService.deleteVolunteerByIdEs(volId);
    }
}
