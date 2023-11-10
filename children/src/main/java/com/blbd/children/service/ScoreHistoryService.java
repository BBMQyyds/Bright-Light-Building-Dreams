package com.blbd.children.service;

import com.blbd.children.dao.entity.ScoreHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author sq
 * @since 2023-11-05
 */
public interface ScoreHistoryService extends IService<ScoreHistory> {
    List<ScoreHistory> getListByChildId(String childId);
    List<ScoreHistory> getListByChildIdPage(String childId,Integer current,Integer size);

}
