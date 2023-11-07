package com.neu.administrator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.administrator.model.po.Supplies;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzm
 */
public interface SuppliesMapper extends BaseMapper<Supplies> {

    @Select("select item_name from supplies_type where item_type = #{itemType}")
    String selectNameByType(@Param("itemType") String itemType);

}
