package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.TaskChild;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface TaskChildMapper extends BaseMapper<TaskChild> {

    int updateAssignmentStage(@Param("childId")String childId,@Param("taskId")String taskId,@Param("assignmentStage")String assignmentStage);
    TaskChild selectByChildId(@Param("childId")String childId,@Param("taskId")String taskId);

}
