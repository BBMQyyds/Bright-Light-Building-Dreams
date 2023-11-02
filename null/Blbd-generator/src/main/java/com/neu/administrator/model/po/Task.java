package com.neu.administrator.model.po;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer score;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    private String video;

    private String subject;

    private String grade;

    private String status;

    @TableField("is_must_do")
    private Boolean mustDo;

    private String content;

    private String name;

    private String taskPhoto;


}
