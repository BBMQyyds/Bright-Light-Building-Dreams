package com.neu.administrator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.mapper.SuppliesMapper;
import com.neu.administrator.mapper.SuppliesTypeMapper;
import com.neu.administrator.model.dto.SuppliesDto;
import com.neu.administrator.model.po.Supplies;
import com.neu.administrator.service.SuppliesService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SuppliesServiceImpl extends ServiceImpl<SuppliesMapper, Supplies> implements SuppliesService {

    @Autowired
    private SuppliesMapper suppliesMapper;
    @Autowired
    private SuppliesTypeMapper suppliesTypeMapper;

    public boolean deleteSupplies(Supplies supplies){
        //从数据库查询物资
        Long quantity= suppliesMapper.selectById(supplies.getId()).getQuantity();
        if(quantity==0) {
            //删除物资
            suppliesMapper.deleteById(supplies.getId());
            return true;
        }
        return false;
    }


    public void saveSupplies(Supplies supplies){
        String id=supplies.getId();
        LambdaQueryWrapper<Supplies> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Supplies::getId, id);
        Supplies temp=suppliesMapper.selectOne(queryWrapper);
        if(temp==null){
            //新增物资
            suppliesMapper.insert(supplies);
        }else{
            //修改物资
            suppliesMapper.updateById(supplies);
        }
    }

    public PageResult<SuppliesDto> searchSupplies(PageParams params,Supplies supplies){
        LambdaQueryWrapper<Supplies> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(Supplies::getDonor,supplies.getDonor());
        queryWrapper.like(Supplies::getItemName,supplies.getItemName());
        queryWrapper.like(Supplies::getItemType,supplies.getItemType());
        queryWrapper.orderByDesc(Supplies::getDonationDate);
        //准备分页参数
        Page page=new Page<>(params.getPageNo(), params.getPageSize());
        Page<Supplies> result=suppliesMapper.selectPage(page,queryWrapper);

        Page<SuppliesDto> dtoResult=new Page<>(params.getPageNo(), params.getPageSize());

        BeanUtils.copyProperties(result,dtoResult,"records");
        //查询出来的数据
        List<Supplies> items=result.getRecords();
        List<SuppliesDto> dtoItems=items.stream().map(item->{
            SuppliesDto dto=new SuppliesDto();
            BeanUtils.copyProperties(item,dto);
            String typeId=item.getItemType();
            String suppliesType=suppliesMapper.selectNameByType(typeId);
            dto.setItemType(suppliesType);
            return dto;
        }).collect(Collectors.toList());

        dtoResult.setRecords(dtoItems);

        //总记录数
        long total=result.getTotal();

        //准备返回的数据
        PageResult<SuppliesDto> pageResult=new PageResult<>(dtoItems,total,params.getPageNo(),params.getPageSize());

        return pageResult;

    }





}
