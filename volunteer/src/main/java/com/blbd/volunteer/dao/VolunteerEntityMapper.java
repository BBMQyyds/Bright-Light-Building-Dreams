package com.blbd.volunteer.dao;


import com.blbd.volunteer.dao.entity.VolunteerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VolunteerEntityMapper {


    int insert(VolunteerEntity volunteerEntity);




}
