package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.OrganizationMapper;
import com.neu.administrator.model.po.Organization;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.OrgService;
import com.neu.base.exception.BlbdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrgServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/7 14:00
 * @Version 1.0
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrganizationMapper organizationMapper;

    public void passQualificationApply(String orgId){
        Organization organization=new Organization();
        organization.setOrgId(orgId);
        organization.setOrgPassIf("0");
        int count = organizationMapper.updateByOrgId(organization);
        if(count<1){
            throw new BlbdException("审核失败！！！");
        }

    }

}
