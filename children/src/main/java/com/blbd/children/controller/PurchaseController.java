package com.blbd.children.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.dao.dto.PurchaseDTO;
import com.blbd.children.dao.entity.Purchase;
import com.blbd.children.mapper.PurchaseMapper;
import com.blbd.children.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PurchaseMapper purchaseMapper;

    //只是用于检索信息而不需要传递数据，GET请求更合适。
    //查看当前孩子的订单列表
    @GetMapping("/list/{childId}")
    public ResponseEntity<Map<String, Object>> purchaseList(@PathVariable String childId) {
        List<PurchaseDTO> dtoList = purchaseService.getListByChildId(childId);

        Map<String, Object> response = new HashMap<>();

        if (dtoList != null && !dtoList.isEmpty()) {
            response.put("success", true);
            response.put("message", "订单列表已成功检索");
            response.put("data", dtoList);
        } else {
            response.put("success", false);
            response.put("message", "该儿童没有任何订单");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    //使用POST请求的主要原因是在创建订单时，通常需要传递一些数据，如订单信息，物品数量等。这些数据通常包含在请求的请求体中，而不是作为 URL 中的参数。
    //POST请求允许你发送这些数据作为请求体，以便服务器能够正确地解析和处理它们，并提供更高的安全性
    //插入订单
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addPurchase(@RequestBody Purchase purchase) {
        int result = purchaseService.addPurchase(purchase);

        Map<String, Object> response = new HashMap<>();

        if (result == 1) {
            response.put("success", true);
            response.put("message", "订单添加成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "订单添加失败");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("/purchaseSubjectRecode/{childId}")
    public ResponseEntity<Map<String, Object>> purchaseSubjectRecode(@PathVariable String childId) {

        Map<String, Object> response = new HashMap<>();

        LambdaQueryWrapper<Purchase> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Purchase::getChildId, childId)
//                .eq(Purchase::getStatus, 1)
                .select(Purchase::getSubNum);

        Integer total = purchaseMapper.selectList(queryWrapper)
                .stream()
                .map(Purchase::getSubNum)
                .reduce(0, Integer::sum);

        if (total != 0) {
            response.put("success", true);
            response.put("data", total);
            response.put("message", "查询孩子的兑换记录成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "暂无兑换记录");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }

    }

    //查看当前孩子的订单列表
    @GetMapping("/list/{childId}/{current}/{size}")
    public ResponseEntity<Map<String, Object>> purchaseListPage(@PathVariable String childId,@PathVariable Integer current,@PathVariable Integer size) {
        List<PurchaseDTO> dtoList = purchaseService.getListByChildIdPage(childId,current,size);

        Map<String, Object> response = new HashMap<>();

        if (dtoList != null && !dtoList.isEmpty()) {
            response.put("success", true);
            response.put("message", "分页订单列表已成功检索");
            response.put("data", dtoList);
        } else {
            response.put("success", false);
            response.put("message", "该儿童分页没有任何订单");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }
}
