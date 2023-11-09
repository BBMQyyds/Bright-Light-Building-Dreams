package com.neu.administrator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.service.ChildService;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {

}

