package com.neu.administrator.model.es;

import lombok.Data;

@Data
public class RequestParams {
    private String id;

    private Integer page;

    private Integer size;

    private String sortBy;

    private Integer score;

    private String name;

    private String grade;

    private String locate;

    private Integer duty;

    private Integer completedTasks;
}
