package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    int updateByOrgId(Organization organization);

    List<Organization> selectByOrgId(Organization organization);

    int countByOrgId(Organization organization);

    List<Organization> selectOrgByPage(@Param("org") Organization organization,@Param("start") Integer start, @Param("size") Integer size);

    int countOrg(Organization organization);
}
