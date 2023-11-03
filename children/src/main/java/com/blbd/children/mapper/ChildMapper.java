package com.blbd.children.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blbd.children.dao.entity.Child;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/1 - 11:13
 */
//在对应的mapper上面继承一个基本接口就可以
@Repository //表示是持久层dao
public interface ChildMapper extends BaseMapper<Child> {

}
