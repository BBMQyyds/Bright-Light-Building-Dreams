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
@TableName("purchase")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String childId;

    private Integer value;

    private LocalDateTime date;

    private Boolean status;

    private String subId;

    private Integer subNum;


}
