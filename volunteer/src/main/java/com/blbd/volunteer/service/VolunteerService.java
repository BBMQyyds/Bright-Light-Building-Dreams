package com.blbd.volunteer.service;

import com.blbd.volunteer.dao.VolunteerEntityMapper;
import com.blbd.volunteer.dao.entity.VolunteerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerEntityMapper volunteerEntityMapper;

    /**
     * 创建用户
     * @param volunteerEntity
     * @return
     */
    public int addVolunteer(VolunteerEntity volunteerEntity){

        int volunteerResult = volunteerEntityMapper.insert(volunteerEntity);

        return 1;
//        }
    }
}
