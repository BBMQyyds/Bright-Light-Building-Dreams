package com.blbd.children.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blbd.children.dao.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blbd.children.dao.entity.Subject;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sq
 * @since 2023-11-01
 */
public interface SubjectService extends IService<Subject> {
    /**
     * 增
     */
    @Override
    default boolean save(Subject entity) {
        return false;
    }

    /**
     * 通过ID删除
     */
    @Override
    default boolean removeById(Serializable id) {
        return false;
    }

    /**
     * 通过ID改
     */
    @Override
    default boolean updateById(Subject entity) {
        return false;
    }

    /**
     * 通过ID查一个商品
     */
    @Override
    default Subject getById(Serializable id) {
        return null;
    }

    /**
     * 查询满足条件的商品列表
     */
    @Override
    default List<Subject> list(Wrapper<Subject> queryWrapper) {
        return null;
    }

    /**
     *  分页查询商品
     */
    @Override
    default <E extends IPage<Subject>> E page(E page, Wrapper<Subject> queryWrapper) {
        return null;
    }
}
