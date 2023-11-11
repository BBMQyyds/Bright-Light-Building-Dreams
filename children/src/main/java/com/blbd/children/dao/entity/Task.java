package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sq
 * @since 2023-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("task")
//@ApiModel(value="Task对象", description="")
public class Task implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 积分
     */
    @TableField("score")
    private Integer score;

    /**
     * 任务开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 任务截止时间
     */
    @TableField("finish_time")
    private Date finishTime;

    /**
     * 任务讲解视频地址
     */
    @TableField("video")
    private String video;

    /**
     * 科目
     */
    @TableField("subject")
    private String subject;

    /**
     * 年级
     */
    @TableField("grade")
    private String grade;

    /**
     * 任务状态
     */
    @TableField("status")
    private String status;

    /**
     * 是否必做
     */
    @TableField("is_must_do")
    private Boolean isMustDo;

    /**
     * 任务内容
     */
    @TableField("content")
    private String content;

    /**
     * 任务名称
     */
    @TableField("name")
    private String name;

    /**
     * 任务图片地址
     */
    @TableField("task_photo")
    private String taskPhoto;

    /**
     * 已完成的人数
     */
    @TableField("complete_num")
    private Integer completedNum;

    /**
     * 该任务的学生最高获得分数
     */
    @TableField("max_score")
    private Integer maxScore;

}
