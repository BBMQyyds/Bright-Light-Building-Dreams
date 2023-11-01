package com.blbd.children.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/1 - 10:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    private String id;
    private String username;
    private Integer score;
    private String password;
    private String name;
    private String grade;
    private String locate;
    private Integer duty;
}
