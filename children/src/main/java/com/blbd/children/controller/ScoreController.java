package com.blbd.children.controller;

import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.dto.ScoreAddDTO;
import com.blbd.children.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children/score")
public class ScoreController {
    @Autowired
    ScoreMapper scoreMapper;

    @GetMapping("/viewScore/{childId}")
    public HttpResponseEntity viewScore(@PathVariable("childId") String childId) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<ScoreAddDTO> scoreAddDTOList = scoreMapper.getScoreTasks(childId);
        if(scoreAddDTOList.isEmpty()){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("没有获得积分");
        } else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(scoreAddDTOList);
            httpResponseEntity.setMessage("查询所有的获得积分记录");
        }
        return httpResponseEntity;
    }
}
