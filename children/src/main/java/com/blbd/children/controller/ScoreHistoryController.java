package com.blbd.children.controller;


import com.blbd.children.dao.entity.ScoreHistory;
import com.blbd.children.service.ScoreHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 孩子积分明细表-总表 VIEW 前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-05
 */
//@Api(tags = "控制器-积分")
@RestController
@RequestMapping("/children/score-history")
public class ScoreHistoryController {
    @Autowired
    private ScoreHistoryService scoreHistoryService;

    //获取孩子的积分总表
    @GetMapping("/total-list/{childId}")
    public ResponseEntity<Map<String, Object>> totalScoreList(@PathVariable String childId) {
        List<ScoreHistory> list = scoreHistoryService.getListByChildId(childId);

        Map<String, Object> response = new HashMap<>();

        if (list!= null && !list.isEmpty()){
            response.put("success",true);
            response.put("message","该儿童的所有积分收支记录已成功检索");
            response.put("data",list);

        } else {
            response.put("success",false);
            response.put("message", "该儿童没有任何积分收支记录");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    //分页获取孩子的积分总表
    @GetMapping("/total-list/{childId}/{current}/{size}")
    public ResponseEntity<Map<String, Object>> PageScoreList(@PathVariable String childId,@PathVariable Integer current,@PathVariable Integer size) {
        List<ScoreHistory> list = scoreHistoryService.getListByChildIdPage(childId,current,size);

        Map<String, Object> response = new HashMap<>();

        if (list!= null && !list.isEmpty()){
            response.put("success",true);
            response.put("message","该儿童的当前页积分收支记录已成功检索");
            response.put("data",list);

        } else {
            response.put("success",false);
            response.put("message", "该儿童当前页积分收支记录");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }
}
