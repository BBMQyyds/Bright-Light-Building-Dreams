package com.neu.administrator.service.impl;

import com.neu.administrator.model.po.Funding;
import com.neu.administrator.mapper.FundingMapper;
import com.neu.administrator.service.FundingService;
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
public class FundingServiceImpl extends ServiceImpl<FundingMapper, Funding> implements FundingService {

}
