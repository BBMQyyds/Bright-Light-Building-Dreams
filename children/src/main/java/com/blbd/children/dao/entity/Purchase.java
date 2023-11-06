package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author sq
 * @since 2023-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("purchase")
//@ApiModel(value="Purchase对象", description="订单")
public class Purchase implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 对应的儿童ID
     */
    @TableField("child_id")
    private String childId;

    /**
     * 消耗的总积分值
     */
    @TableField("value")
    private Integer value;

    /**
     * 订单的兑换时间,即生成时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date date;

    /**
     * 订单的状态(进行中、已完成)
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean status;

    /**
     * 下单物品的id
     */
    @TableField("sub_id")
    private String subId;

    /**
     * 下单物品的个数
     */
    @TableField("sub_num")
    private Integer subNum;


}
