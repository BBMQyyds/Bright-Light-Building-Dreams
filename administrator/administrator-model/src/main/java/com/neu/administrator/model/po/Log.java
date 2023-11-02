package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logId;

    private LocalDateTime logDate;

    private String logContent;

    private String logVolunteerId;

    private String logChildId;


}
