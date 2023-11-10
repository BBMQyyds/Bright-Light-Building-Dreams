package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blbd.children.dao.entity.ScoreHistory;
import com.blbd.children.mapper.ScoreHistoryMapper;
import com.blbd.children.service.ScoreHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类 VIEW
 * 积分明细
 *      获得积分表--已批改任务：作业审批通过获得积分
 *      消耗积分表--订单/兑换商品：插入订单消耗积分
 *          展示当前孩子的订单列表（消耗积分表）：购买物品的图片，物品名称，物品描述，物品花费的总积分值，订单的状态
 *      积分收支表--前二者按时间的总排序：
 *          暂时以儿童提交任务时间为积分获得时间
 *          平台由前端通过判断event_type自行填充
 *
 * 积分收支表需求：
 *
 * </p>
 *
 * @author sq
 * @since 2023-11-05
 */
@Service
public class ScoreHistoryServiceImpl extends ServiceImpl<ScoreHistoryMapper, ScoreHistory> implements ScoreHistoryService {
    @Autowired
    private ScoreHistoryMapper scoreHistoryMapper;

    /**
     * 查看当前孩子的积分收支表
     */
    @Override
    public List<ScoreHistory> getListByChildId(String childId) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("child_id",childId);

        List<ScoreHistory> scoreHistories = scoreHistoryMapper.selectByMap(map);

        if (scoreHistories.isEmpty()){
            return new ArrayList<>();
        }

        return scoreHistories;
    }

    /**
     * 分页查看当前孩子的积分收支表
     */
    @Override
    public List<ScoreHistory> getListByChildIdPage(String childId,Integer current,Integer size) {
        Page<ScoreHistory> page = new Page<>(current, size);

        QueryWrapper<ScoreHistory> wrapper = new QueryWrapper<>();
        wrapper.eq("child_id",childId);

        scoreHistoryMapper.selectPage(page,wrapper);

        List<ScoreHistory> scoreHistoryList = page.getRecords();

        //总共多少条记录total
        //System.out.println(page.getTotal());

        if (scoreHistoryList.isEmpty()){
            return new ArrayList<>();
        }

        return scoreHistoryList;
    }
}
