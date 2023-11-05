package com.blbd.children.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author sq ♥ovo♥
 * @date 2023/11/4 - 16:57
 */
@SpringBootTest
public class PurchaseServiceTests {
    @Autowired
    PurchaseService purchaseService;

    /**
     * 测试查看当前孩子的订单列表：购买物品的图片，物品名称，物品花费的总积分值，订单的状态
     */
    @Test
    public void testGetListByChildId() {
        purchaseService.getListByChildId("2").forEach(System.out::println);
    }
}
