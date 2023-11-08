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
@TableName("funding")
public class Funding implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 捐赠人或组织
     */
    private String donor;

    /**
     * 捐赠金额
     */
    private Long amount;

    /**
     * 资金用途的描述
     */
    private String descriptions;

    /**
     * 捐赠日期
     */
    private LocalDateTime donationDate;


}
