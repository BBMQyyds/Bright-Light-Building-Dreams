package com.neu.administrator.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;

/**
 * @ClassName Qualification
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 0:07
 * @Version 1.0
 */
public interface QualificationService {
    Boolean passVolQualification(String volId);

    Boolean passOrgQualification(String orgId);
    Boolean rejectVolQualification(String volId);
    Boolean rejectOrgQualification(String orgId);

    void rejectVolQualificationES(String volId) throws IOException;

    void passVolQualificationES(String volId) throws IOException;

}
