package com.blbd.volunteer.dao.entity;

import lombok.Data;

@Data
public class OrganizationEntity {
    private String orgId;
    private String orgName;
    private String orgIntroduction;
    private int orgNumber;
    private String orgAddress;
    private String orgVolunteerId;
    private String orgPassIf;
}