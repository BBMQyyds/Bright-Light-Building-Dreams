package com.neu.administrator;

import com.alibaba.fastjson.JSON;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.model.es.ChildConstants;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.service.AdministratorInfoService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static com.neu.administrator.model.es.ChildConstants.CHILD_MAPPING_TEMPLATE;

@SpringBootTest
@Slf4j
public class AdministratorTests {


    @Autowired
    private  AdministratorInfoService administratorInfoService;

    private RestHighLevelClient client;

    @Autowired
    private ChildMapper childMapper;


    @Autowired
    @Test
    public void LoginTest(){

        log.info(administratorInfoService.list().toString());
        System.out.println(administratorInfoService.list().toString());


    }

    @BeforeEach
    public void setUp(){
        this.client=new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://123.56.248.217:9200")
        ));
    }
    @AfterEach
    public void tearDown() throws IOException {
        this.client.close();
    }

    //创建索引库
    @Test
    public void createChildIndex() throws IOException{
        CreateIndexRequest request=new CreateIndexRequest("child");
        request.source(CHILD_MAPPING_TEMPLATE, XContentType.JSON);
        //client.indices()方法的返回值是IndicesClient类型，封装了所有与索引库操作有关的方法。
        client.indices().create(request, RequestOptions.DEFAULT);

    }

    //判断索引库是否存在
    @Test
    public void testExistChildIndex() throws IOException {
        GetIndexRequest request=new GetIndexRequest("child");
        boolean exists=client.indices().exists(request,RequestOptions.DEFAULT);
        System.out.println(exists?"索引库存在":"索引库不存在");
    }


    //批量插入数据
    @Test
    public void testBulkRequest() throws IOException{
        //批量查询孩子数据
        List<Child> children=childMapper.selectList(null);
        System.out.println(children.toString());

        //批量插入数据
        BulkRequest request=new BulkRequest();
        //准备参数
        for(Child child:children){
            request.add(
                    new IndexRequest("child")
                            .id(child.getId())
                            .source(JSON.toJSONString(child),XContentType.JSON)
            );
        }
        client.bulk(request,RequestOptions.DEFAULT);

    }

    //查询文档数据
    @Test
    public void testGetDocumentById() throws IOException{
        GetRequest request=new GetRequest("child","1");
        GetResponse response=client.get(request,RequestOptions.DEFAULT);
        String json=response.getSourceAsString();
        Child child=JSON.parseObject(json,Child.class);
        System.out.println(child.toString());

    }

    //修改文档数据
    @Test
    public void updateDocumentById() throws IOException{
        UpdateRequest request=new UpdateRequest("child","1");
        request.doc(
                "username","sb"
        );
        client.update(request,RequestOptions.DEFAULT);

    }








}
