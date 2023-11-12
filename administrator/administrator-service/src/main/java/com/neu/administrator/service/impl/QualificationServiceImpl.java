package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.OrganizationMapper;
import com.neu.administrator.mapper.VolunteerMapper;
import com.neu.administrator.model.po.Organization;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.QualificationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QualificationServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 0:09
 * @Version 1.0
 */
@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    VolunteerMapper volunteerMapper;

    @Autowired
    OrganizationMapper organizationMapper;



    @Override
    public Boolean passVolQualification(String volId) {
        Volunteer volunteer = new Volunteer();
        volunteer.setVolId(volId);
        volunteer.setIfPass("1");
        int i = volunteerMapper.updateByVolId(volunteer);

        return i>=1;
    }

    @Override
    public Boolean passOrgQualification(String orgId) {
        Organization organization = new Organization();
        organization.setOrgId(orgId);
        organization.setOrgPassIf("1");
        int i=organizationMapper.updateByOrgId(organization);

        return i>=1;
    }

    @Override
    public Boolean rejectVolQualification(String volId) {
        Volunteer volunteer = new Volunteer();
        volunteer.setVolId(volId);
        volunteer.setIfPass("-1");
        int i = volunteerMapper.updateByVolId(volunteer);

        return i>=1;
    }

    @Override
    public Boolean rejectOrgQualification(String orgId) {
        Organization organization = new Organization();
        organization.setOrgId(orgId);
        organization.setOrgPassIf("-1");
        int i=organizationMapper.updateByOrgId(organization);

        return i>=1;
    }
}
