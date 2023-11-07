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
@TableName("funding_usage")
public class FundingUsage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 记录使用的资金
     */
    private String fundId;

    /**
     * 资金的使用日期
     */
    private LocalDateTime useDate;

    /**
     * 使用的金额
     */
    private Long useAmonut;

    /**
     * 接收资金的人或组织
     */
    private String recipient;

    /**
     * 记录使用的描述
     */
    private String descriptions;

    /**
     * 记录其他备注需要的信息
     */
    private String notes;


}
