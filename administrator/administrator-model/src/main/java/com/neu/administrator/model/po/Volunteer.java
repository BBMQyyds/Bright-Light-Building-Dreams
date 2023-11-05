package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("volunteer")
public class Volunteer implements Serializable {

    private static final long serialVersionUID = 1L;


    private String volId;

    private String volUsername;

    private String volPassword;

    private String volName;

    private String volLocate;

    private String volOrganization;

    private Integer volDuty;

    private Integer volCorrectedTasks;

    private String volTel;


}
