package com.blbd.children.service;

import com.blbd.children.dao.entity.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


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

    /**
     * 测试插入订单
     */
    @Test
    public void testAddPurchase() {
        // 创建一个 Purchase 对象，模拟需要插入的数据
        Purchase purchase = new Purchase();
        purchase.setChildId("child123");
        purchase.setValue(100);
        purchase.setStatus(true);
        purchase.setSubId("item456");
        purchase.setSubNum(2);

        int result = purchaseService.addPurchase(purchase);

        //检查返回的结果是否符合预期
        if (result == 1){
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

    }
}
