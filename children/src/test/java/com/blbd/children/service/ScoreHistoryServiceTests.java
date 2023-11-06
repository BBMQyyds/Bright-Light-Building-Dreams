package com.blbd.children.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/5 - 15:57
 */
@SpringBootTest
public class ScoreHistoryServiceTests {
    @Autowired
    private ScoreHistoryService scoreHistoryService;

    /**
     * 测试查看当前孩子的积分收支表
     */
    @Test
    public void testGetListByChildId() {
        scoreHistoryService.getListByChildId("5").forEach(System.out::println);
    }


}
