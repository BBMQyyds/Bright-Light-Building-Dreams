package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.VolunteerMapper;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.VolService;
import com.neu.base.exception.BlbdException;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName VolService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/7 13:07
 * @Version 1.0
 */
@Service
public class VolServiceImpl implements VolService {
    @Autowired
    private VolunteerMapper volunteerMapper;
    public void passQualificationApply(String volId){
        Volunteer volunteer=new Volunteer();
        volunteer.setVolId(volId);
        volunteer.setPass(true);
        int count = volunteerMapper.updateByVolId(volunteer);
        if(count<1){
            throw new BlbdException("审核失败！！！");
        }

    }
}
