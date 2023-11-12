package com.neu.administrator.api;


import com.neu.administrator.model.dto.QualificationsDto;
import com.neu.administrator.service.QualificationService;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@Api(value = "资质审核管理接口")
@RestController
@RequestMapping("/qualifications")
public class QualificationsController {
    @Autowired
    private QualificationService qualificationService;


    @ApiOperation("通过志愿者资质申请")
    @PostMapping("/vol/pass")
    public RestResponse<String> passVolQualifications(@RequestBody QualificationsDto qualificationsDto) throws IOException {
        //通过资质里面的属性进行判断
        //todo 成功失败逻辑
        String volId=qualificationsDto.getVolId();

        Boolean passed = qualificationService.passVolQualification(volId);

        if (passed){
            qualificationService.passVolQualificationES(volId);
            return RestResponse.success("通过资质申请成功");
        }else {
            return RestResponse.success("通过资质申请失败");
        }



    }


    @ApiOperation("通过组织资质申请")
    @PostMapping("/org/pass")
    public RestResponse<String> passOrgQualifications(@RequestBody QualificationsDto qualificationsDto){
        //通过资质里面的属性进行
        //todo 成功失败逻辑
        String orgId=qualificationsDto.getOrgId();
        Boolean passed = qualificationService.passOrgQualification(orgId);

        if(passed){
            return RestResponse.success("通过资质申请成功");
        }else {
            return RestResponse.success("通过资质申请失败");
        }



    }


    @ApiOperation("拒绝志愿者资质申请")
    @PostMapping("/vol/reject")
    public RestResponse<String> rejectVolQualifications(@RequestBody QualificationsDto qualificationsDto) throws IOException {
        //通过资质里面的属性进行判断
        //todo 成功失败逻辑
        String volId=qualificationsDto.getVolId();

        Boolean passed = qualificationService.rejectVolQualification(volId);

        if (passed){
            qualificationService.rejectVolQualificationES(volId);
            return RestResponse.success("通过资质申请成功");
        }else {
            return RestResponse.success("通过资质申请失败");
        }



    }


    @ApiOperation("通过组织资质申请")
    @PostMapping("/org/reject")
    public RestResponse<String> rejectOrgQualifications(@RequestBody QualificationsDto qualificationsDto){
        //通过资质里面的属性进行
        //todo 成功失败逻辑
        String orgId=qualificationsDto.getOrgId();
        Boolean passed = qualificationService.rejectOrgQualification(orgId);

        if(passed){
            return RestResponse.success("通过资质申请成功");
        }else {
            return RestResponse.success("通过资质申请失败");
        }



    }

}
