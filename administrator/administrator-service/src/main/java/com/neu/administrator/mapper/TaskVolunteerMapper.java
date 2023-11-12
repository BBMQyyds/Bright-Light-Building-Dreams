package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.TaskVolunteer;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface TaskVolunteerMapper extends BaseMapper<TaskVolunteer> {
    int insertTaskVol(TaskVolunteer taskVolunteer);

    int insertTaskVolunteer(TaskVolunteer taskVolunteer);

    int updateTaskVolunteer(TaskVolunteer taskVolunteer);
}
