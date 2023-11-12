package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Volunteer;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface VolunteerMapper extends BaseMapper<Volunteer> {
    Volunteer selectByVolId(@Param("id") String volId);

    int deleteByVolId(@Param("volId")String volId);

    int updateByVolId(Volunteer volunteer);

    void insertVol(Volunteer volunteer);
}
