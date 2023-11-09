package com.blbd.children.service.impl;

import com.blbd.children.dao.dto.ScoreAddDTO;
import com.blbd.children.mapper.ScoreMapper;
import com.blbd.children.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/9 19:10
 * @Version 1.0
 */
@Service
public class ScoreServiceImpl {
    @Autowired
    private ScoreMapper scoreMapper;


    public List<ScoreAddDTO> getScoreTasks(String childId) {
        return scoreMapper.getScoreTasks(childId);
    }
}
