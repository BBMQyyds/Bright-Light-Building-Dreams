package com.blbd.children.controller;


import com.blbd.children.dao.dto.PurchaseDTO;
import com.blbd.children.service.PurchaseService;
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
 *  订单与孩子关联信息 前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-04
 */
@RestController
@RequestMapping("/children/purchase")
//@Api(tags = "控制器-purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    //查看当前孩子的订单列表
    @GetMapping("/list/{childId}")
    public ResponseEntity<Map<String,Object>> purchaseList(@PathVariable String childId){
        List<PurchaseDTO> dtoList = purchaseService.getListByChildId(childId);

        Map<String, Object> response = new HashMap<>();

        if (dtoList != null && !dtoList.isEmpty()){
            response.put("success",true);
            response.put("message","订单列表已成功检索");
            response.put("data",dtoList);
        } else {
            response.put("success", false);
            response.put("message", "该儿童没有任何订单");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }


}

