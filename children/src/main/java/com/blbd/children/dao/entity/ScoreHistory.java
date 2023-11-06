package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author sq
 * @since 2023-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("score_history")
//@ApiModel(value="ScoreHistory对象", description="积分明细-收支总记录VIEW")
public class ScoreHistory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 对应的儿童ID
     */
    @TableField("child_id")
    private String childId;

    /**
     * 日期
     */
    @TableField("event_time")
    private Date eventTime;

    /**
     * 收支积分
     */
    @TableField("score")
    private Long score;

    /**
     * 条目类型：获得积分，支出积分
     */
    @TableField("event_type")
    private String eventType;

    /**
     * 详情
     */
    @TableField("event_detail")
    private String eventDetail;


}
