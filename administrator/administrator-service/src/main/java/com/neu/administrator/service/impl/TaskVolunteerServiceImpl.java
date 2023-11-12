package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.mapper.TaskVolunteerMapper;
import com.neu.administrator.model.po.TaskVolunteer;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.TaskVolunteerService;
import com.neu.base.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        //根据儿童id与任务id查询志愿者任务是否存在
        Integer i = taskVolunteerMapper.selectTaskVolunteer(taskVolunteer);
        if(i==0){
            //不存在，插入志愿者任务
            if(taskVolunteerMapper.insertTaskVolunteer(taskVolunteer)>0){
                return true;
            }else {
                return false;
            }
        }else{
            //存在，更新志愿者任务
            if(taskVolunteerMapper.updateTaskVolunteer(taskVolunteer)>0){
                return true;
            }else {
                return false;
            }
        }


    }

    @Override
    public PageResult<Volunteer> searchVolunteersNotAssign(TaskVolunteer taskVolunteer) {
        List<Volunteer> volunteers = taskVolunteerMapper.selectTaskVolunteerNotAssign(taskVolunteer);

        return new PageResult<Volunteer>(volunteers);
    }
}
