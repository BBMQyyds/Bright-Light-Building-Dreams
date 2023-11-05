package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *志愿者所属于的组织
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
