package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.FundingLog;
import com.neu.administrator.model.po.Log;
import com.neu.administrator.model.po.SuppliesUsage;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface LogMapper extends BaseMapper<Log> {

    List<FundingLog> selectFundingLog(@Param("start") Long start, @Param("limit") Long limit);

    Integer countFundingLog();

    List<SuppliesUsage> selectSuppliesLog(@Param("start") Long start, @Param("limit") Long limit);

    Integer countSuppliesLog();
}
