package com.neu.administrator.api;


import com.neu.administrator.model.dto.SuppliesDto;
import com.neu.administrator.model.po.Funding;
import com.neu.administrator.model.po.Supplies;
import com.neu.administrator.service.SuppliesService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import com.neu.base.model.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "物资管理接口")
@RequestMapping("/supplies")
public class SuppliesController {

    @Autowired
    private SuppliesService suppliesService;

    @ApiOperation("查看物资分页")
    @PostMapping("/search")
    public RestResponse<PageResult> searchFund(@RequestBody Supplies supplies, PageParams params){
        PageResult<SuppliesDto> result=suppliesService.searchSupplies(params,supplies);
        return RestResponse.success(result);
    }


    @ApiOperation("删除物资")
    @PostMapping("/delete")
    public RestResponse<String> deleteFund(@RequestBody Supplies supplies){
        boolean flag=suppliesService.deleteSupplies(supplies);
        if(flag){
            return RestResponse.success("删除成功");
        }
            return RestResponse.validfail("删除失败");
    }

    @ApiOperation("新增或修改物资")
    @PostMapping("/save")
    public RestResponse<String> saveFund(@RequestBody Supplies supplies){
        suppliesService.saveSupplies(supplies);
        return RestResponse.success("保存成功");
    }


}
