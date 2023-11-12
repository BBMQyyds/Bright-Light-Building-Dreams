package com.neu.administrator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.es.PageResult;
import com.neu.administrator.model.es.RequestParams;
import com.neu.administrator.model.es.SearchVolParams;
import com.neu.administrator.model.po.Administrator;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import com.neu.base.model.RestResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface AdministratorInfoService extends IService<Administrator> {

    //es
    //分页搜索
    PageResult search(RequestParams params) ;

    //删除mq同步
    void deleteById(String id);

    //改查mq同步
    void saveById(Child child);

    //es删除
    void deleteByIdEs(String id);

    //es保存
    void saveByIdEs(Child child);


    void deleteVolunteerById(String id);



    void saveVolunteerById(Volunteer volunteer);

    PageResult searchVol(SearchVolParams params);
    void deleteVolunteerByIdEs(String id);
    void saveVolunteerByIdEs(Volunteer volunteer);

    PageResult searchChildInNeed(RequestParams params);

    PageResult searchChildNotAssign(TaskDto params);
}
