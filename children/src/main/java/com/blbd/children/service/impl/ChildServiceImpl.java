package com.blbd.children.service.impl;

import com.blbd.children.dao.entity.Child;
import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.service.ChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {
    @Autowired
    private ChildMapper childMapper;
    @Override
    public List<Child> verifyChild(Child child){
        List<Child> result = childMapper.queryList(child);
        return result;
    }
}
