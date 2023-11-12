package com.neu.administrator.model.dto;

import lombok.Data;

/**
 * @ClassName SearchOrgRequest
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 14:39
 * @Version 1.0
 */
@Data
public class SearchOrgRequest {
    private Integer page;

    private Integer size;

    private String passed;

    private String orgName;
}
