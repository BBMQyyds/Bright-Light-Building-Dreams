package com.neu.administrator.api;


import com.neu.administrator.model.po.Funding;
import com.neu.administrator.service.FundingService;
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

@Slf4j
@RestController
@Api(value="资金与物资管理接口")
@RequestMapping("/fund")
public class FundController {

    @Autowired
    private FundingService fundingService;

    @ApiOperation("查看资金分页")
    @PostMapping("/search")
    public RestResponse<PageResult> searchFund(@RequestBody Funding fund, PageParams params){
        PageResult<Funding> result=fundingService.searchFund(params,fund);
        return RestResponse.success(result);
    }


    @ApiOperation("删除资金")
    @PostMapping("/delete")
    public RestResponse<String> deleteFund(@RequestBody Funding fund){
        boolean flag=fundingService.deleteFund(fund);
        if(flag){
            return RestResponse.success("删除成功");
        }
        return RestResponse.validfail("删除失败");
    }

    @ApiOperation("新增或修改资金")
    @PostMapping("/save")
    public RestResponse<String> saveFund(@RequestBody Funding fund){
        fundingService.saveFund(fund);
        return RestResponse.success("保存成功");
    }









}
