package com.blbd.children.service;

import com.blbd.children.config.UUIDUtil;
import com.blbd.children.dao.entity.Child;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
public interface ChildService extends IService<Child> {

    Child c = new Child();

    List<Child> verifyChild(Child c);
}
