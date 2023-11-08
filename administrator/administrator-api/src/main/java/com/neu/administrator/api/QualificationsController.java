package com.neu.administrator.api;


import com.neu.administrator.service.ChildService;
import com.neu.administrator.service.OrgService;
import com.neu.administrator.service.VolService;
import com.neu.administrator.service.impl.VolServiceImpl;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "资质审核管理接口")
@RestController
@RequestMapping("/qualifications")
public class QualificationsController {

    @Autowired
    private VolService volService;

    @Autowired
    private ChildService childService;

    @Autowired
    private OrgService orgService;


    @ApiOperation("通过儿童资质申请")
    @PostMapping("/passChild/{childId}")
    public RestResponse<String> passChildQualifications(@PathVariable String childId){
        childService.passQualificationApply(childId);

        return RestResponse.success("审核成功！！！");
    }


    @ApiOperation("通过志愿者资质申请")
    @PostMapping(value = "/passVol/{volId}")
    public RestResponse<String> passVolQualificationApply(@PathVariable String volId){
        volService.passQualificationApply(volId);

        return RestResponse.success("审核成功！！！");
    }

    @ApiOperation("通过组织资质申请")
    @PostMapping(value = "/passOrg/{orgId}")
    public RestResponse<String> passOrgQualificationApply(@PathVariable String orgId){
        volService.passQualificationApply(orgId);

        return RestResponse.success("审核成功！！！");
    }

}
