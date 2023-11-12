package com.neu.administrator.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

}
