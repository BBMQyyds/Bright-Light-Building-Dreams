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
@TableName("child")
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private Integer score;

    private String password;

    private String name;

    private String grade;

    private String locate;

    private Integer duty;

    private Integer completedTasks;

    private String volunteerId;


}
