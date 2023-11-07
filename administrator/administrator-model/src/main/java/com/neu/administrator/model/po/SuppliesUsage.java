package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("supplies_usage")
public class SuppliesUsage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 使用物资的id
     */
    private String suppliesId;

    /**
     * 使用物资的日期
     */
    private LocalDateTime useDate;

    /**
     * 使用物资的数量
     */
    private Long useQuantity;

    /**
     * 接收物资的孩子或组织
     */
    private String recipient;

    /**
     * 使用这批物资的描述
     */
    private String descriptions;

    /**
     * 备注其他信息
     */
    private String notes;


}
