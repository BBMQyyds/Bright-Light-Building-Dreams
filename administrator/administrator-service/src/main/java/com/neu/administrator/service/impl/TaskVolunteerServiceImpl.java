package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.mapper.TaskVolunteerMapper;
import com.neu.administrator.model.po.TaskVolunteer;
import com.neu.administrator.service.TaskVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TaskVolunteerServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 13:22
 * @Version 1.0
 */
@Service
public class TaskVolunteerServiceImpl implements TaskVolunteerService {
    @Autowired
    private TaskVolunteerMapper taskVolunteerMapper;
    @Autowired
    private TaskChildMapper taskChildMapper;

    @Override
    public boolean assignTask(TaskVolunteer taskVolunteer) {

        //插入志愿者任务
        if(taskVolunteerMapper.updateTaskVolunteer(taskVolunteer)>0){

                return true;

        }
        return false;
    }
}
