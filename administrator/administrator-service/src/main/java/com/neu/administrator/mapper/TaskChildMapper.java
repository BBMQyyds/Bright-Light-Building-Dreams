package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.dto.TaskChildDto;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.TaskChild;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface TaskChildMapper extends BaseMapper<TaskChild> {
    int updateAssignmentStage(@Param("childId")String childId, @Param("taskId")String taskId, @Param("assignmentStage")String assignmentStage);
    TaskChild selectByChildId(@Param("childId")String childId,@Param("taskId")String taskId);

    List<TaskChildDto> searchTasks(@Param("taskId") String taskId, @Param("isCompleted") Boolean isCompleted, @Param("isCorrected") Boolean isCorrected, @Param("pageNo") Long pageNo, @Param("pageSize") Long pageSize);

    Long searchTasksCount(@Param("taskId") String taskId, @Param("isCompleted") Boolean isCompleted, @Param("isCorrected") Boolean isCorrected);

    int updateVolIdTaskChild(@Param("taskId")String taskId,@Param("childId")String childId,@Param("volunteerId")String volunteerId);

    void insertTaskChild(TaskChild taskChild);

}
