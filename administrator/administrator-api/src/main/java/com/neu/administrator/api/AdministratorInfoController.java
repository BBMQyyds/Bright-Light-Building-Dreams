package com.neu.administrator.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neu.administrator.model.po.Administrator;
import com.neu.administrator.service.AdministratorInfoService;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "管理员信息管理接口", tags = "管理员信息管理接口，提供管理员信息的增、删、改、查")
@RestController
@Slf4j
public class AdministratorInfoController {


    @Autowired
    private AdministratorInfoService administratorInfoService;

    @ApiOperation("管理员登录接口")
    @PostMapping("/login")
    public RestResponse<Administrator> login(HttpServletRequest request , @RequestBody Administrator administrator){
        //获取账户
        String username=administrator.getUsername();//前端获取的账户
        String password=administrator.getPassword();//前端获取的密码
        //判断账户是否存在
        LambdaQueryWrapper<Administrator> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Administrator::getUsername,username);//查询条件
        //从数据库查询获取账户信息
        Administrator admin= administratorInfoService.getOne(queryWrapper);
        if(admin==null){
            return RestResponse.validfail("账户不存在");
        }
        //如果账户存在则进行密码比对
        if(!admin.getPassword().equals(password)){
            return RestResponse.validfail("密码错误，请重新输入");
        }
        //否则账号正常，登录成功,存入session
        request.getSession().setAttribute("administrator",admin.getId());
        //返回该用户的信息
        return RestResponse.success(admin);
    }


}
