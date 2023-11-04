package com.blbd.children.service.impl;

import com.blbd.children.dao.dto.PurchaseDTO;
import com.blbd.children.dao.entity.Purchase;
import com.blbd.children.dao.entity.Subject;
import com.blbd.children.mapper.PurchaseMapper;
import com.blbd.children.mapper.SubjectMapper;
import com.blbd.children.service.PurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 *  儿童端对订单的需求：
 *        展示当前孩子的订单列表：购买物品的图片，物品名称，物品花费的总积分值，订单的状态
 *        展现订单详细信息（购物车？）：购买物品的图片，物品名称，单个物品花费的积分值，物品数量，订单的状态
 * </p>
 *
 * @author sq
 * @since 2023-11-04
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    private PurchaseMapper orderMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 查看当前孩子的订单列表：购买物品的图片，物品名称，物品花费的总积分值，订单的状态
     * @return
     */
    @Override
    public List<PurchaseDTO> getListByChildId(String childId) {
        ArrayList<PurchaseDTO> purchaseDtos = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();

        map.put("child_id",childId);
        List<Purchase> purchases = orderMapper.selectByMap(map);

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
