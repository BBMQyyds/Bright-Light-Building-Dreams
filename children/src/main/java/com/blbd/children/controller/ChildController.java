package com.blbd.children.controller;


import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.service.impl.ChildServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
//给文档加注释
@Api(tags = "控制器-child")
@RestController
@RequestMapping("/children/child")
public class ChildController {

    @Autowired
    private ChildServiceImpl childService;
    /**
     * 登录验证
     */

    @RequestMapping(value="/childLogin",method= RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity childLogin(@RequestBody Child child){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        try{
            List<Child> hasChild = childService.verifyChild(child);
            if(CollectionUtils.isEmpty(hasChild)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(null);
                httpResponseEntity.setMessage("用户或密码错误");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasChild);
                httpResponseEntity.setMessage("登录成功");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}

