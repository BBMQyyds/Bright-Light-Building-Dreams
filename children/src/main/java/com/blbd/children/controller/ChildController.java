package com.blbd.children.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.beans.HttpResponseEntity;
import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.service.impl.ChildServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxr
 * @since 2023-11-01
 */
//给文档加注释
//@Api(tags = "控制器-child")
@Controller
@RestController
@RequestMapping("/children/child")
public class ChildController {

    @Resource
    ChildMapper childMapper;
    /**
     * 登录验证
     */
    @PostMapping("/loginChild")
    public HttpResponseEntity loginChild(@RequestParam("username") String username,
                                         @RequestParam("password") String password){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        //将输入的数据与数据库进行匹配，看是否存在
        Child hasChild = childMapper.selectOne(Wrappers.<Child>lambdaQuery().eq(Child::getUsername, username)
                .eq(Child::getPassword, password));
        if (hasChild == null) {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("用户或密码错误");
        } else {

            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(hasChild);
            httpResponseEntity.setMessage("登录成功");


        }
        return httpResponseEntity;
    }

}

