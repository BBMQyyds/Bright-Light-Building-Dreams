package com.neu.administrator.api;

import com.neu.administrator.model.po.FundingLog;
import com.neu.administrator.model.po.SuppliesUsage;
import com.neu.administrator.service.LogService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author CY
 * @Date 2023/11/12 18:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/searchFundingLog")
    public PageResult<FundingLog> searchFundingLog(@RequestBody PageParams params){
        return logService.searchFundingLog(params);
    }

    @PostMapping("/searchSuppliesLog")
    public PageResult<SuppliesUsage> searchSuppliesLog(@RequestBody PageParams params){
        return logService.searchSuppliesLog(params);
    }
}
