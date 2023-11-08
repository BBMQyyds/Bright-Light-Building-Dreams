package com.neu.administrator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.mapper.FundingMapper;
import com.neu.administrator.model.po.Funding;
import com.neu.administrator.service.FundingService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundingServiceImpl extends ServiceImpl<FundingMapper, Funding> implements FundingService {

    @Autowired
    private FundingMapper fundingMapper;

    //删除资金
    public boolean deleteFund(Funding funding){
        //从数据库查询资金
        Long balance= fundingMapper.selectById(funding.getId()).getAmount();
        if(balance==0) {
            //删除资金
            fundingMapper.deleteById(funding.getId());
            return true;
        }
        return false;
    }

    //新增或修改资金
    public void saveFund(Funding funding){
        String id=funding.getId();
        LambdaQueryWrapper<Funding> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Funding::getId, id);
        Funding temp=fundingMapper.selectOne(queryWrapper);
        if(temp==null){
            //新增资金
            fundingMapper.insert(funding);
        }else{
            //修改资金
            fundingMapper.updateById(funding);
        }
    }

    //查询资金
    public PageResult<Funding> searchFund(PageParams pageParams, Funding funding){
        LambdaQueryWrapper<Funding> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Funding::getDonor,funding.getDonor());
        //分页参数
        Page page=new Page<>(pageParams.getPageNo(),pageParams.getPageSize());
        Page<Funding> result=fundingMapper.selectPage(page,queryWrapper);
        //数据
        List<Funding> items=result.getRecords();
        //总记录数
        long total=result.getTotal();
        //准备返回的数据
        PageResult<Funding> pageResult=new PageResult<>(items,total,pageParams.getPageNo(),pageParams.getPageSize());

        return pageResult;
    }




}
