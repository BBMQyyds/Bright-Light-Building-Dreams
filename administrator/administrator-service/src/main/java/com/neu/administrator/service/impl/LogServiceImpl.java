package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.LogMapper;
import com.neu.administrator.model.po.FundingLog;
import com.neu.administrator.model.po.SuppliesUsage;
import com.neu.administrator.service.LogService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 18:59
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<FundingLog> searchFundingLog(PageParams params) {
        List<FundingLog> fundingLogs = logMapper.selectFundingLog((params.getPageNo()-1)* params.getPageSize(),params.getPageSize());
        int count = logMapper.countFundingLog();
        return new PageResult<>(fundingLogs,count);
    }

    @Override
    public PageResult<SuppliesUsage> searchSuppliesLog(PageParams params) {
        List<SuppliesUsage> suppliesUsages = logMapper.selectSuppliesLog((params.getPageNo()-1)* params.getPageSize(),params.getPageSize());
        int count = logMapper.countSuppliesLog();
        return new PageResult<>(suppliesUsages,count);
    }
}
