package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Child;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface ChildMapper extends BaseMapper<Child> {

    List<Child> selectNotAssignChildren(String taskId);
}
