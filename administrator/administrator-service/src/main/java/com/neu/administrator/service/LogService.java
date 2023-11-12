package com.neu.administrator.service;

import com.neu.administrator.model.po.FundingLog;
import com.neu.administrator.model.po.SuppliesUsage;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;

/**
 * @ClassName LogService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 18:59
 * @Version 1.0
 */
public interface LogService {
    PageResult<FundingLog> searchFundingLog(PageParams params);

    PageResult<SuppliesUsage> searchSuppliesLog(PageParams params);

}
