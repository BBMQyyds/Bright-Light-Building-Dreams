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
     * 资金目前的金额
     */
    private Long amount;

    /**
     * 资金的描述
     */
    private String descriptions;

    /**
     * 资金的类别
     */
    private LocalDateTime fundingType;


}
