package com.neu.administrator.service;

import com.neu.administrator.model.po.TaskVolunteer;
import com.neu.administrator.model.po.Volunteer;
import com.neu.base.model.PageResult;

/**
 * @ClassName TaskVolunteerService
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 13:22
 * @Version 1.0
 */
public interface TaskVolunteerService {
    boolean assignTask(TaskVolunteer taskVolunteer);

    PageResult<Volunteer> searchVolunteersNotAssign(TaskVolunteer taskVolunteer);
}
