package com.blbd.children.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Subject;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.mapper.SubjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
//@Api(tags = "控制器-商品")
@RestController
@RequestMapping("/children/subject")
public class SubjectController {
    @Resource
    SubjectMapper subjectMapper;
    @RequestMapping("/viewAllSubject")
    public HttpResponseEntity viewAllSubject(){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<Subject> subjects = subjectMapper.selectList(null);
        if (subjects.size() == 0){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("无可兑换物品");
        }else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(subjects);
            httpResponseEntity.setMessage("查询所有物品成功");
        }
        return httpResponseEntity;
    }
    @GetMapping("/QueryOneSubject/{id}")
    public HttpResponseEntity QueryOneSubject(@PathVariable("id") String id){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        Subject subjects = subjectMapper.selectOne(Wrappers.<Subject>lambdaQuery().eq(Subject::getId, id));
        if (subjects == null){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("查询物品详细信息失败");
        }else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(subjects);
            httpResponseEntity.setMessage("查询物品的详细信息成功");
        }
        return httpResponseEntity;
    }
}

