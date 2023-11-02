package com.blbd.children.dao.entity;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value="Child对象", description="")
public class Child {
    private String id;
    private String username;
    private Integer score;
    private String password;
    private String name;
    private String grade;
    private String locate;
    private Integer duty;

    public Child(String id, String username, Integer score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    public Child() {

    }
}
