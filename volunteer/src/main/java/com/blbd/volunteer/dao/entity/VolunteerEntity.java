package com.blbd.volunteer.dao.entity;

import lombok.Data;

@Data
public class VolunteerEntity {
    private String volId;
    private String volUsername;
    private String volPassword;
    private String volName;
    private String volLocate;
    private String volOrganization;
    private int volDuty;
    private int volCorrectedTasks;
    private String volTel;

    public String getVolId() {
        return volId;
    }

    public void setVolId(String volId) {
        this.volId = volId;
    }

    public String getVolUsername() {
        return volUsername;
    }

    public void setVolUsername(String volUsername) {
        this.volUsername = volUsername;
    }

    public String getVolPassword() {
        return volPassword;
    }

    public void setVolPassword(String volPassword) {
        this.volPassword = volPassword;
    }

    public String getVolName() {
        return volName;
    }

    public void setVolName(String volName) {
        this.volName = volName;
    }

    public String getVolLocate() {
        return volLocate;
    }

    public void setVolLocate(String volLocate) {
        this.volLocate = volLocate;
    }

    public String getVolOrganization() {
        return volOrganization;
    }

    public void setVolOrganization(String volOrganization) {
        this.volOrganization = volOrganization;
    }

    public int getVolDuty() {
        return volDuty;
    }

    public void setVolDuty(int volDuty) {
        this.volDuty = volDuty;
    }

    public int getVolCorrectedTasks() {
        return volCorrectedTasks;
    }

    public void setVolCorrectedTasks(int volCorrectedTasks) {
        this.volCorrectedTasks = volCorrectedTasks;
    }

    public String getVolTel() {
        return volTel;
    }

    public void setVolTel(String volTel) {
        this.volTel = volTel;
    }
}