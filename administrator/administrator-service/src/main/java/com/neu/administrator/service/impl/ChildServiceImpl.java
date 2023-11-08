package com.neu.administrator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.ChildService;
import com.neu.base.exception.BlbdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {
    @Autowired
    private ChildMapper childMapper;
    @Override
    public void passQualificationApply(String childId) {
        Child child=new Child();
        child.setId(childId);
        child.setPass(true);
        int count = childMapper.updateByChildId(child);
        if(count<1){
            throw new BlbdException("审核失败！！！");
        }
    }
}

