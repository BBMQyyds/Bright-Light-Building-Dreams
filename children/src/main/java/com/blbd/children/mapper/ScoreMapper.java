package com.blbd.children.mapper;
import com.blbd.children.dao.dto.ScoreAddDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository//有问题则删除
public interface ScoreMapper {


    @Select("SELECT tc.score as num, tc.task_finish_time as date, t.name as taskName " +
            "FROM task_child tc " +
            "INNER JOIN child c ON tc.child_id = c.id " +
            "INNER JOIN task t ON tc.task_id = t.id " +
            "WHERE tc.is_corrected = 2 AND c.id = #{childId}")
    List<ScoreAddDTO> getScoreTasks(@Param("childId") String childId);

}
