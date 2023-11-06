package com.blbd.children.service;

import com.blbd.children.dao.dto.ScoreDTO;
import com.blbd.children.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreMapper scoreMapper;

    @Autowired
    public ScoreService(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    public List<ScoreDTO> getScoreTasks(String childId) {
        return scoreMapper.getScoreTasks(childId);
    }
}
