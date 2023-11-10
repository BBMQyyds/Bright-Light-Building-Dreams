package com.blbd.children.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.ChatLink;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.service.ChatLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/children/video")
public class ChatLinkController {
    @Autowired
    ChildMapper childMapper;
    @Autowired
    ChatLinkService chatLinkService;
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

    @GetMapping("/getVideoCallNum/{childId}")
    public ResponseEntity<Map<String, Object>> getVideoCallNum(@PathVariable String childId) {
        HashMap<String, Object> response = new HashMap<>();
        int VideoCallNum = Math.toIntExact(chatLinkService.lambdaQuery()
                .eq(ChatLink::getSenderId, childId).or().eq(ChatLink::getReceiverId, childId)
                .count());

        if(VideoCallNum != 0 ){
            response.put("success",true);
            response.put("message","统计视频通话次数成功");
            response.put("data",VideoCallNum);

            return ResponseEntity.ok(response);
        } else {
            response.put("success",false);
            response.put("message", "无法统计视频通话次数");
            response.put("data", null);

            return ResponseEntity.ok(response);
        }
    }
}

