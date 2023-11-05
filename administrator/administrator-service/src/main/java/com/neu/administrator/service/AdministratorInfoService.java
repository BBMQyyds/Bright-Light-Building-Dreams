package com.neu.administrator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.administrator.model.es.PageResult;
import com.neu.administrator.model.es.RequestParams;
import com.neu.administrator.model.po.Administrator;
import com.neu.administrator.model.po.Child;
import com.neu.base.model.RestResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface AdministratorInfoService extends IService<Administrator> {

    //es
    //分页搜索
    PageResult search(RequestParams params) ;

    //删除
    void deleteById(String id);

    //改查
    void saveById(Child child);

    //更新数据
    public void updateIndex () throws IOException;



}
