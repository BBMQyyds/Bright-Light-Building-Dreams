package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="TaskChild对象", description="")
public class TaskChild implements Serializable {

    private static final long serialVersionUID = 1L;

    private String childId;

    private String taskId;

    private Integer score;

    private Date taskStartTime;

    private Date taskFinishTime;

    private Date taskEndTime;

    private Boolean isCompleted;

    private Boolean isCorrected;

    private String assignmentStage;


}
