package com.blbd.children.mapper;

import com.blbd.children.dao.entity.TaskChild;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
@Repository
public interface TaskChildMapper extends BaseMapper<TaskChild> {

}
