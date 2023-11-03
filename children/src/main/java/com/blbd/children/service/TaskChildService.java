package com.blbd.children.service;

import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 *  查看已提交未批改任务
 *  查看已批改（已完成）任务
 *  根据任务名查询任务列表
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
public interface TaskChildService extends IService<TaskChild> {


}
