package com.neu.administrator.model.po;

import java.time.LocalDateTime;
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
@TableName("log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logId;

    private LocalDateTime logDate;

    private String logContent;

    private String logVolunteerId;

    private String logChildId;


}
