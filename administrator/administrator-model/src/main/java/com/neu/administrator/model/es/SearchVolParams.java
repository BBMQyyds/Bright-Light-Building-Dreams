package com.neu.administrator.model.es;

import lombok.Data;

/**
 * @ClassName SearchVolParams
 * @Description TODO
 * @Author CY
 * @Date 2023/11/5 15:52
 * @Version 1.0
 */
@Data
public class SearchVolParams {


    private Integer page;

    private Integer size;

    private String sortBy;

    private String volUsername;

    private String volPassword;

    private String volName;

    private String volLocate;

    private String volOrganization;


    private String volTel;
    private String passed;
}
