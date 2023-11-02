package com.blbd.volunteer.dao;


import com.blbd.volunteer.dao.entity.VolunteerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VolunteerEntityMapper {


    //新增志愿者信息，即注册，测试成功
    int insert(VolunteerEntity volunteerEntity);




}
