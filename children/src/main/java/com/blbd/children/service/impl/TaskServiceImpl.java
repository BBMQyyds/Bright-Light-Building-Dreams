
package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.dao.entity.TaskVolunteer;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 *  儿童端对任务的需求：
 *      查看所有任务列表（包括各个年级的）
 *      查看必做且未提交任务（年级必须符合）
 * </p>
 *
 * @author sq
 * @since 2023-11-02
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    // 获取年级匹配且未提交的必做任务的新方法
    public List<Task> getUnsubmittedMandatoryTasks(String grade) {

        return null;
    }

    @Override
    public List<Task> getAllTaskList() {
        return taskMapper.selectList(null);
    }

    @Override
    public int addTask(Task entity) {
        return taskMapper.insert(entity);   //受影响的行数
    }

    @Override
    public boolean deleteTaskById(String id) {
        return false;
    }

    @Override
    public int editTask(Task entity) {
        return taskMapper.updateById(entity);
    }

    @Override
    public Task queryTaskById(String id) {
        return taskMapper.selectById(id);
    }

    @Override
    public List<Task> list(Wrapper queryWrapper) {
        return null;
    }

    /**
     * 查询所有任务的最高得分
     */
    @Override
    public List<Map<String, Object>> getMaxScoreForEachTask() {
        /*QueryWrapper<TaskVolunteer> taskVolunteerWrapper = new QueryWrapper<>();
        taskVolunteerWrapper.select("task_id, MAX(score) AS max_score")
                .groupBy("task_id");

        QueryWrapper<TaskChild> taskChildWrapper = new QueryWrapper<>();
        taskChildWrapper.select("task_id, NULL AS max_score");

        String combinedTasksSql = "(" + taskVolunteerWrapper.getSqlSelect() + ") UNION ALL " +
                "(" + taskChildWrapper.getSqlSelect() + ")";

        BaseMapper<Task> baseMapper = getBaseMapper();
        List<Map<String, Object>> result = baseMapper.selectMaps(new QueryWrapper<Task>().select("task_id, MAX(max_score) AS max_score").inSql("task_id", combinedTasksSql).groupBy("task_id"));

        return result;*/
        return null;
    }


}
