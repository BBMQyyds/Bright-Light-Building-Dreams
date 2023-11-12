package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("funding_log")
public class FundingLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 使用资金的组织id
     */
    private String organizationId;

    /**
     * 资金使用的用户id
     */
    private String userId;

    /**
     * 该条日志产生的日期
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 改变的金额
     */
    private Long changeAmonut;

    /**
     * 是捐助或支出
     */
    private String changeType;

    /**
     * 对该资金使用的描述
     */
    private String descriptions;

    /**
     * 记录其他备注需要的信息
     */
    private String notes;

    private String organizationName;


}
