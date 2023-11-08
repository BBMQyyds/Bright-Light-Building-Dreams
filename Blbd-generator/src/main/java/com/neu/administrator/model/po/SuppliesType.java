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
@TableName("supplies_type")
public class SuppliesType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 物资的类型,1:食品，2：衣物，3教材
     */
    private String itemType;

    /**
     * 1:食品，2：衣物，3教材
     */
    private String itemName;


}
