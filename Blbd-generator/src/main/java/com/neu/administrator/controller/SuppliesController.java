package com.neu.administrator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neu.administrator.service.SuppliesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzm
 */
@Slf4j
@RestController
@RequestMapping("supplies")
public class SuppliesController {

    @Autowired
    private SuppliesService  suppliesService;
}
