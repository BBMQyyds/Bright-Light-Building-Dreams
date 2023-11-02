package com.blbd.volunteer.controller;

import com.blbd.volunteer.dao.entity.VolunteerEntity;
import com.blbd.volunteer.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;


    /**
     * 添加
     * @param userEntity
     * @return
     */


}
