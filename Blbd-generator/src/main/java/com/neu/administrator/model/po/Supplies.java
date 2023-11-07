package com.neu.administrator.model.po;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("supplies")
public class Supplies implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 物资的名称
     */
    private String itemName;

    /**
     * 物资的类型,1:食品，2：衣物，3教材
     */
    private String itemType;

    /**
     * 捐赠物资的数量
     */
    private Long quantity;

    /**
     * 其他相关的信息
     */
    private String notes;

    /**
     * 捐赠的日期
     */
    private LocalDateTime donationDate;

    /**
     * 捐赠的人或组织
     */
    private String donor;

    /**
     * 物资相关的作用
     */
    private String descriptions;


}
