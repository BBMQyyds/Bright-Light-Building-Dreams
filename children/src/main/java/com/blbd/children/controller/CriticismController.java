package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.dao.dto.CriticismDTO;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.CriticismMapper;
import com.blbd.children.mapper.TaskChildMapper;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.mapper.TaskVolunteerMapper;
import com.blbd.children.service.CriticismService;
import com.blbd.children.dao.entity.TaskVolunteer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/9 21:11
 * @Version 1.0
 */
@Controller
@RestController
@RequestMapping("/children/criticism")
public class CriticismController {
    @Autowired
    CriticismMapper criticismMapper;
    @GetMapping("/criticismDetails/{childId}/{taskId}")
    public ResponseEntity<Map<String,Object>> criticismDetails(@PathVariable String childId, @PathVariable String taskId) {
        // 执行查询task_volunteer表
        List<CriticismDTO> criticismDTO = criticismMapper.selectList(childId, taskId);

        HashMap<String, Object> response = new HashMap<>();
        if (criticismDTO.toString() != null && !criticismDTO.toString().isEmpty()){
            response.put("success",true);
            response.put("message","获取任务反馈的详情成功");
            response.put("data",criticismDTO);

            return ResponseEntity.ok(response);
        } else {
            response.put("success",false);
            response.put("message", "无法获取详情");
            response.put("data", null);

            return ResponseEntity.ok(response);
        }
    }

}
