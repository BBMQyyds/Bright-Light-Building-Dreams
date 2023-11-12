package com.neu.administrator.service.impl;

import com.neu.administrator.mapper.OrganizationMapper;
import com.neu.administrator.mapper.VolunteerMapper;
import com.neu.administrator.model.po.Organization;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.QualificationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    RestHighLevelClient client;



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

    @Override
    public void rejectVolQualificationES(String volId) throws IOException {
        UpdateRequest request = new UpdateRequest("volunteer", volId);

        // Create a map representing the full document with the updated values
        Map<String, Object> updatedDocument = new HashMap<>();
        updatedDocument.put("ifPass", "-1");

        request.doc(updatedDocument); // Set the updated document

        client.update(request, RequestOptions.DEFAULT);
    }

    @Override
    public void passVolQualificationES(String volId) throws IOException {
        UpdateRequest request = new UpdateRequest("volunteer", volId);

        // Create a map representing the full document with the updated values
        Map<String, Object> updatedDocument = new HashMap<>();
        updatedDocument.put("ifPass", "1");

        request.doc(updatedDocument); // Set the updated document

        client.update(request, RequestOptions.DEFAULT);
    }

}
