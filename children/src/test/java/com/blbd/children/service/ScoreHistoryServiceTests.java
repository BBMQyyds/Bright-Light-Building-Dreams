package com.blbd.children.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blbd.children.dao.entity.ScoreHistory;
import com.blbd.children.mapper.ScoreHistoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/5 - 15:57
 */
@SpringBootTest
public class ScoreHistoryServiceTests {
    @Autowired
    private ScoreHistoryService scoreHistoryService;

    @Autowired
    private ScoreHistoryMapper scoreHistoryMapper;

    /**
     * 测试查看当前孩子的积分收支表
     */
    @Test
    public void testGetListByChildId() {
        scoreHistoryService.getListByChildId("5").forEach(System.out::println);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage(){
        Page<ScoreHistory> page = new Page<>(2, 2);

        scoreHistoryMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);

        //System.out.println(page.getTotal());
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testGetListByChildIdPage(){
        List<ScoreHistory> list = scoreHistoryService.getListByChildIdPage("1", 2, 2);

        list.forEach(System.out::println);
    }

}
