package com.blbd.volunteer;

import com.blbd.volunteer.dao.VolunteerEntityMapper;
import com.blbd.volunteer.dao.entity.VolunteerEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = VolunteerApplication.class)
@RunWith(SpringRunner.class)
class LogApplicationTests {

    @Autowired
    private VolunteerEntityMapper volunteerEntityMapper;

    @Test
    public void testInsertVolunteer() {
        VolunteerEntity volunteerEntity = new VolunteerEntity();
        volunteerEntity.setVolName("wuhao");
        volunteerEntity.setVolPassword("123456");
        volunteerEntity.setVolId("2");

        // 执行插入操作
        int rowsInserted = volunteerEntityMapper.insert(volunteerEntity);

        // 检查插入是否成功
        assert rowsInserted == 1; // 期望插入一行数据

        // 还可以添加其他断言，如检查插入后的数据是否正确
    }

    }


