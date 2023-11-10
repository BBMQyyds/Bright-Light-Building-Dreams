package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blbd.children.dao.dto.PurchaseDTO;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.dao.entity.Purchase;
import com.blbd.children.dao.entity.ScoreHistory;
import com.blbd.children.dao.entity.Subject;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.mapper.PurchaseMapper;
import com.blbd.children.mapper.SubjectMapper;
import com.blbd.children.service.PurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 *  儿童端对订单的需求（消耗积分表）：
 *        兑换物品（类似加入购物车）：购买物品的图片，物品名称，物品描述，单个物品花费的积分值，物品数量，总消耗积分数
 *                =>先获取物品详情用于展示--查询物品【商品/物品模块】
 *                =>前端再传一个订单回来存进订单表并扣除儿童对应积分（订单生成时间后端自动填充,刚刚创建的订单状态应该是进行中即0）--插入订单【订单模块】
 *        展示当前孩子的订单列表（消耗积分表）：购买物品的图片，物品名称，物品描述，物品花费的总积分值，订单的状态
 * </p>
 *
 * @author sq
 * @since 2023-11-04
 */
@Service
@Accessors(chain = true)    //支持链式写法
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private ChildMapper childMapper;

    /**
     * 查看当前孩子的订单列表：购买物品的图片，物品名称，物品花费的总积分值，订单的状态
     */
    @Override
    public List<PurchaseDTO> getListByChildId(String childId) {
        ArrayList<PurchaseDTO> purchaseDtos = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();

        map.put("child_id",childId);
        List<Purchase> purchases = purchaseMapper.selectByMap(map);

        if (purchases.isEmpty()){
            return purchaseDtos;
        }

        for (Purchase purchase : purchases) {
            PurchaseDTO dto = new PurchaseDTO();

            String subId = purchase.getSubId();
            Subject subject = subjectMapper.selectById(subId);

            dto.setId(purchase.getId());
            dto.setSubId(subId);
            dto.setSubPhoto(subject.getSubPhoto());
            dto.setName(subject.getName());
            dto.setValue(purchase.getValue());     //订单里写的就是总积分了
            dto.setStatus(purchase.getStatus());

            purchaseDtos.add(dto);
        }

        return purchaseDtos;
    }

    /**
     * 插入订单,消耗积分
     */
    @Override
    public int addPurchase(Purchase purchase) {
        //返回值通常是插入操作的影响行数，通常是一个整数，表示成功插入的记录数。
        //如果插入成功，它会返回 1，表示一行记录已插入。如果插入失败则返回 0
        //purchase.setStatus(false);
        int result1 = purchaseMapper.insert(purchase);

        String childId = purchase.getChildId();

        Child child = childMapper.selectById(childId);

        int newScore = child.getScore() - purchase.getValue();
        child.setScore(newScore);

        int result2 = childMapper.updateById(child);

        if (result1 == 1 && result2 == 1){
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 分页查看当前孩子的订单列表：购买物品的图片，物品名称，物品花费的总积分值，订单的状态
     */
    @Override
    public List<PurchaseDTO> getListByChildIdPage(String childId, Integer current, Integer size) {
        ArrayList<PurchaseDTO> purchaseDtos = new ArrayList<>();
        Page<Purchase> page = new Page<>(current, size);

        QueryWrapper<Purchase> wrapper = new QueryWrapper<>();
        wrapper.eq("child_id",childId);

        purchaseMapper.selectPage(page,wrapper);

        List<Purchase> purchases = page.getRecords();

        if (purchases.isEmpty()){
            return purchaseDtos;
        }

        for (Purchase purchase : purchases) {
            PurchaseDTO dto = new PurchaseDTO();

            String subId = purchase.getSubId();
            Subject subject = subjectMapper.selectById(subId);

            dto.setId(purchase.getId());
            dto.setSubId(subId);
            dto.setSubPhoto(subject.getSubPhoto());
            dto.setName(subject.getName());
            dto.setValue(purchase.getValue());     //订单里写的就是总积分了
            dto.setStatus(purchase.getStatus());

            purchaseDtos.add(dto);
        }

        return purchaseDtos;
    }
}
