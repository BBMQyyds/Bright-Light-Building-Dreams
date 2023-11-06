package com.neu.administrator.service.impl;

import com.neu.administrator.service.TaskService;
import com.neu.base.exception.BlbdException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 16:14
 * @Version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    RestHighLevelClient client;

    @Override
    public void allocateTaskToVol(String childId, String taskId) {
        // 创建RestHighLevelClient


        // 创建查询
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.matchAllQuery(),
                new ScriptScoreFunctionBuilder(new Script(
                        "_score * (doc['volCorrectedTasks'].value + 1) / (doc['volDuty'].value * doc['volDuty'].value + 1) * 100")));

        // 创建SearchSourceBuilder
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(functionScoreQueryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(1);
        sourceBuilder.sort(SortBuilders.scoreSort().order(SortOrder.DESC));

        // 创建SearchRequest
        SearchRequest searchRequest = new SearchRequest("volunteer"); // 替换为你的索引名称
        searchRequest.source(sourceBuilder);


        // 执行查询
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new BlbdException("分配任务失败");//
        }

        // 处理查询结果
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        String volunteerJson = searchHits[0].getSourceAsString();
        System.out.println(volunteerJson);
    }
}

