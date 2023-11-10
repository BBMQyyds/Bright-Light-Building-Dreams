package com.blbd.children.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blbd.children.dao.dto.CriticismDTO;
import com.blbd.children.dao.entity.TaskVolunteer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/9 23:18
 * @Version 1.0
 */
@Repository
public interface TaskVolunteerMapper extends BaseMapper<TaskVolunteer> {


}
