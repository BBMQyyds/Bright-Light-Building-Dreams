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

    private String volSfz;

    private String ifPass;


}
