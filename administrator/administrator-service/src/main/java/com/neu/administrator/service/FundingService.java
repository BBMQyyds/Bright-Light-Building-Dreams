package com.neu.administrator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.administrator.model.po.Funding;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;

public interface FundingService extends IService<Funding> {
    //删除资金
    public boolean deleteFund(Funding funding);

    //新增或修改资金
    public void saveFund(Funding funding);

    //查询资金
    public PageResult<Funding> searchFund(PageParams pageParams, Funding funding);
}
