package com.neu.administrator.model.po;

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
@TableName("organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orgId;

    private String orgName;

    private String orgIntroduction;

    private Integer orgNumber;

    private String orgAddress;

    private String orgVolunteerId;

    private String orgPassIf;


}
