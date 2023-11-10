package com.blbd.children.service.impl;

import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.service.ChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {

}
