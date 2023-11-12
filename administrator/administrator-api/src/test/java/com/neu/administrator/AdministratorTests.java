package com.neu.administrator;

import com.alibaba.fastjson.JSON;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.mapper.OrganizationMapper;
import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.mapper.VolunteerMapper;
import com.neu.administrator.model.dto.SearchOrgRequest;
import com.neu.administrator.model.dto.TaskChildDto;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.es.*;
import com.neu.administrator.model.es.VolunteerConstants.*;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.FundingLog;
import com.neu.administrator.model.po.TaskVolunteer;
import com.neu.administrator.model.po.Volunteer;
import com.neu.administrator.service.*;
import com.neu.base.model.PageParams;
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
import org.springframework.transaction.annotation.Transactional;

import javax.jws.HandlerChain;
import java.io.IOException;
import java.util.List;

import static com.neu.administrator.model.es.ChildConstants.CHILD_MAPPING_TEMPLATE;

@SpringBootTest
@Slf4j
public class AdministratorTests {


    @Autowired
    private QualificationService qualificationService;

    @Autowired
    private  AdministratorInfoService administratorInfoService;

    @Autowired
    TaskChildService taskChildService;



    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private VolunteerMapper volunteerMapper;


    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private OrganizationMapper organizationMapper;


    @Autowired
    private TaskChildMapper taskChildMapper;


    @Autowired
    private LogService logService;

    @Autowired
    private TaskVolunteerService taskVolunteerService;



    @Test
    public void LoginTest(){

        log.info(administratorInfoService.list().toString());
        System.out.println(administratorInfoService.list().toString());


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



    //创建索引库
    @Test
    public void createVolunteerIndex() throws IOException{
        CreateIndexRequest request=new CreateIndexRequest("volunteer");
        request.source(VolunteerConstants.VOL_MAPPING_TEMPLATE, XContentType.JSON);
        //client.indices()方法的返回值是IndicesClient类型，封装了所有与索引库操作有关的方法。
        client.indices().create(request, RequestOptions.DEFAULT);

    }





    //判断索引库是否存在
    @Test
    public void testExistVolunteerIndex() throws IOException {
        GetIndexRequest request=new GetIndexRequest("volunteer");
        boolean exists=client.indices().exists(request,RequestOptions.DEFAULT);
        System.out.println(exists?"索引库存在":"索引库不存在");
    }


    //批量插入数据
    @Test
    public void testVolunteerBulkRequest() throws IOException{
        //批量查询志愿者数据
        List<Volunteer> volunteers=volunteerMapper.selectList(null);
        System.out.println(volunteers.toString());

        //批量插入数据
        BulkRequest request=new BulkRequest();
        //准备参数
        for(Volunteer volunteer:volunteers){
            request.add(
                    new IndexRequest("volunteer")
                            .id(volunteer.getVolId())
                            .source(JSON.toJSONString(volunteer),XContentType.JSON)
            );
        }
        client.bulk(request,RequestOptions.DEFAULT);

    }

    //查询文档数据
    @Test
    public void testVolunteerGetDocumentById() throws IOException{
        GetRequest request=new GetRequest("volunteer","22");
        GetResponse response=client.get(request,RequestOptions.DEFAULT);
        String json=response.getSourceAsString();
        Volunteer child=JSON.parseObject(json,Volunteer.class);
        System.out.println(child.toString());

    }

    //修改文档数据
    @Test
    public void updateVolunteerDocumentById() throws IOException{
        UpdateRequest request=new UpdateRequest("volunteer","22");
        request.doc(
                "name","sb"
        );
        client.update(request,RequestOptions.DEFAULT);

    }




    //测试志愿者CRUD
    @Test
    public void searchVolTest(){
        SearchVolParams params=new SearchVolParams();
        params.setVolName("周");
        params.setPage(1);
        params.setSize(10);

        PageResult pageResult = administratorInfoService.searchVol(params);

        log.info(pageResult.toString());
    }


    //测试志愿者CRUD
    @Test
    public void searchChildTest(){
        RequestParams params=new RequestParams();

        params.setName("Child");
        params.setPage(1);
        params.setSize(10);

        PageResult pageResult = administratorInfoService.search(params);

        log.info(pageResult.toString());
    }

    @Test
    @Transactional
    public void deleteVolunteerByIdTest(){
        administratorInfoService.deleteVolunteerById("001");
    }

    @Test
    @Transactional
    public void saveVolunteerByIdTest(){
        Volunteer volunteer=new Volunteer();

        volunteer.setVolId("00252251");
        administratorInfoService.saveVolunteerById(volunteer);
    }

    @Test
    @Transactional
    public void selectByVolId(){
        Volunteer temp=volunteerMapper.selectByVolId("001");
        log.info(temp.toString());
    }

    @Test
    @Transactional
    public void updateByVolId(){
        Volunteer volunteer=new Volunteer();

    }



    //儿童测试
    @Test
    public void searchTest(){
        RequestParams requestParams = new RequestParams();
        requestParams.setPage(1);
        requestParams.setSize(5);
        PageResult search = administratorInfoService.search(requestParams);
        System.out.println(search);
    }



    //资质审核
    @Test
    public void passVolTest(){
        //qualificationService.passVolQualification("c3623d557a88410c94c6425144eaa441");
        //qualificationService.rejectVolQualification("c3623d557a88410c94c6425144eaa441");

        //qualificationService.passOrgQualification("805c35b81b3c41e5911256614780c228");
        qualificationService.rejectOrgQualification("805c35b81b3c41e5911256614780c228");
    }


    @Test
    public void testSearchOrg(){
        SearchOrgRequest searchOrgRequest = new SearchOrgRequest();

        searchOrgRequest.setOrgName("件");

        searchOrgRequest.setPassed("0");

        searchOrgRequest.setPage(1);
        searchOrgRequest.setSize(10);
        PageResult pageResult = administratorInfoService.searchOrg(searchOrgRequest);


        System.out.println(pageResult);
    }

    @Test
    public void rejectVolQualificationESTest(){
        try {
            qualificationService.rejectVolQualificationES("26");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchTasksTest(){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId("1");
        PageParams pageParams = new PageParams(1L, 10L);
        com.neu.base.model.PageResult<TaskChildDto> taskChildDtoPageResult = taskChildService.searchTasks(taskDto, pageParams);
        System.out.println(taskChildDtoPageResult);

    }

    @Test
    public void searchFundinglogTest(){
        com.neu.base.model.PageResult<FundingLog> result= logService.searchFundingLog(new PageParams(1L,10L));
        System.out.println(result);
    }
    @Test
    void assignTaskTest(){
        TaskVolunteer taskVolunteer = new TaskVolunteer();
        taskVolunteer.setTaskId("3");
        taskVolunteer.setVolunteerId("999");
        taskVolunteer.setChildId("1");
        taskVolunteerService.assignTask(taskVolunteer);
    }

    @Test
    void searchVolunteersNotAssignTest(){
        TaskVolunteer taskVolunteer = new TaskVolunteer();
        taskVolunteer.setTaskId("2");
        taskVolunteer.setChildId("1");

        com.neu.base.model.PageResult<Volunteer> result = taskVolunteerService.searchVolunteersNotAssign(taskVolunteer);
        System.out.println(result);
    }

}