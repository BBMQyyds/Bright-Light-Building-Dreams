package com.blbd.children.dao.dto;

import lombok.Data;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/4 - 20:14
 */
@Data
public class PurchaseDTO {
    private String id;          // 订单的唯一标识
    private String subId;       // 物品的唯一标识
    private String subPhoto;    // 物品图片
    private String name;        // 物品名称
    private Integer value;         // 物品花费的总积分值(物品价值×物品数)
    private Boolean status;        // 订单的状态
}
