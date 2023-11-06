package com.blbd.children.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author sq ovo
 * @date 2023/11/1 - 10:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("child")
@AllArgsConstructor
//@ApiModel(value="Child对象", description="")
public class Child {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    @TableField("username")
    private String username;
    @TableField("score")
    private Integer score;
    @TableField("password")
    private String password;
    @TableField("name")
    private String name;
    @TableField("grade")
    private String grade;
    @TableField("locate")
    private String locate;
    @TableField("duty")
    private Integer duty;
    @TableField("completed_tasks")
    private Integer completedTasks;
    @TableField("volunteer_id")
    private String volunteerId;
    public Child(String id, String username, Integer score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    public Child() {

    }
}
