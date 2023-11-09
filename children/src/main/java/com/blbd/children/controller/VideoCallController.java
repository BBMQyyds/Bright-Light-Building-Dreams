package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.ChildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/children/video")
public class VideoCallController {
    @Autowired
    ChildMapper childMapper;
    @RequestMapping("/videoCall/{childId}")
    public HttpResponseEntity videoCall(@PathVariable("childId") String childId) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        String volunteerId = childMapper.selectOne(Wrappers.<Child>lambdaQuery()
                        .select(Child::getVolunteerId)
                        .eq(Child::getId, childId))
                .getVolunteerId();

        if(volunteerId.isEmpty()){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有正在进行的任务");
        }else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(volunteerId);
            httpResponseEntity.setMessage("查看所有时效的任务");
        }
        return httpResponseEntity;
    }

}

