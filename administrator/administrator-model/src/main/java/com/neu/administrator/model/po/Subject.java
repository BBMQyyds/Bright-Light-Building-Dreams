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
@TableName("subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer value;

    private String content;

    private String donateId;

    private String name;

    private String subPhoto;


}
