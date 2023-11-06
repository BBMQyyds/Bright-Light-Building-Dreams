package com.blbd.children.controller;

import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.dto.ScoreDTO;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.ScoreMapper;
import com.blbd.children.service.ChildService;
import com.blbd.children.service.ScoreService;
import com.blbd.children.service.TaskChildService;
import com.blbd.children.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/children/score")
public class ScoreController {
    @Autowired
    ScoreMapper scoreMapper;

    @RequestMapping("/viewScore")
    public HttpResponseEntity viewScore(@RequestParam String childId) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<ScoreDTO> scoreDTOList = scoreMapper.getScoreTasks(childId);
        if(scoreDTOList.isEmpty()){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有获得积分");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(scoreDTOList);
            httpResponseEntity.setMessage("查询所有的获得积分记录");
        }
        return httpResponseEntity;
    }
}
