package com.neu.administrator.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.mapper.AdministratorMapper;
import com.neu.administrator.model.po.Administrator;
import com.neu.administrator.service.AdministratorInfoService;
import org.springframework.stereotype.Service;

@Service
public class AdministratorInfoServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorInfoService {

}
