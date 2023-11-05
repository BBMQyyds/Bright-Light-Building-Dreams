package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
//@ApiModel(value="Subject对象", description="商品/可兑换物品")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("value")
    private Integer value;
    @TableField("content")
    private String content;
    @TableField("donate_id")
    private String donateId;
    @TableField("name")
    private String name;
    private String subPhoto;

}
