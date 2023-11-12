package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Task;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface TaskMapper extends BaseMapper<Task> {

    List<String> selectChildIdsByTaskId(String taskId);



}
