package com.blbd.children.mapper;

import com.blbd.children.dao.dto.CriticismDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/9 21:18
 * @Version 1.0
 */
@Repository
public interface CriticismMapper {
    @Select("SELECT" +
            "    tc.is_corrected as isCorrected ," +
            "    tc.homework_photo as homeworkPhoto ," +
            "    t.task_photo as taskPhoto ,"+
            "    t.name as name ," +
            "    t.content as content ," +
            "    tv.approval_comments as comment" +
            " FROM" +
            "    task_child tc" +
            "    INNER JOIN task t ON tc.task_id = t.id" +
            "    LEFT JOIN child c ON tc.child_id = c.id" +
            "    LEFT JOIN task_volunteer tv ON tc.child_id = tv.child_id" +
            "        AND tc.task_id = tv.task_id" +
            "        AND c.volunteer_id = tv.volunteer_id" +
            " WHERE" +
            "    tc.child_id = #{childId} " +
            "    AND tc.task_id = #{taskId} ")
    List<CriticismDTO> selectList(@Param("childId") String childId, @Param("taskId") String taskId);
}
