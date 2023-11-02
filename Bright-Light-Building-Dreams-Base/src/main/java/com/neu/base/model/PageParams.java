package com.neu.base.model;


import lombok.Data;
import lombok.ToString;

@Data
@ToString//打印日志，输出方便

public class PageParams {
    //当前页面
    private Long pageNo = 1L;
    //每页显示的记录数
    private Long pageSize = 30L;

    public PageParams() {
    }

    public PageParams(Long pageNo, Long pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

}
