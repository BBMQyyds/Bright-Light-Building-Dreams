package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("subject")
//@ApiModel(value="Subject对象", description="")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer value;

    private String content;

    private String donateId;

    private String name;


}