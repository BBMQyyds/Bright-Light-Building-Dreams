package com.neu.administrator.service.impl;

import com.neu.administrator.model.po.Child;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.service.ChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzm
 */
@Slf4j
@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {

}