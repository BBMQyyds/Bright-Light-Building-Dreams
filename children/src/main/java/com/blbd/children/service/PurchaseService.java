package com.blbd.children.service;

import com.blbd.children.dao.dto.PurchaseDTO;
import com.blbd.children.dao.entity.Purchase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sq
 * @since 2023-11-04
 */
public interface PurchaseService extends IService<Purchase> {
    /**
     * 查看当前孩子的订单列表
     * @return
     */
    public List<PurchaseDTO> getListByChildId(String childId);

}
