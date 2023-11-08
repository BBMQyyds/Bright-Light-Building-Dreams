package com.neu.administrator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.administrator.model.dto.SuppliesDto;
import com.neu.administrator.model.po.Funding;
import com.neu.administrator.model.po.Supplies;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;

public interface SuppliesService extends IService<Supplies> {

    //删除物资
    public boolean deleteSupplies(Supplies supplies);

    //新增或修改物资
    public void saveSupplies(Supplies supplies);

    //查询物资
    public PageResult<SuppliesDto> searchSupplies(PageParams pageParams, Supplies supplies);



}
