package com.neu.administrator.api;


import com.neu.administrator.model.dto.QualificationsDto;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "资质审核管理接口")
@RestController
@RequestMapping("/qualifications")
public class QualificationsController {

    @ApiOperation("通过资质申请")
    @PostMapping("/check")
    public RestResponse<String> checkQualifications(@RequestBody QualificationsDto qualificationsDto){
        //通过资质里面的属性进行判断
        //todo 成功失败逻辑
        return RestResponse.success("通过资质申请成功");
    }


}
