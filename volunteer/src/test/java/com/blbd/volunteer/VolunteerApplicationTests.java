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
class VolunteerApplicationTests {

    @Autowired
    private VolunteerEntityMapper volunteerEntityMapper;


    //新增志愿者测试，测试成功
    @Test
    public void testInsertVolunteer() {
        VolunteerEntity volunteerEntity = new VolunteerEntity();
        volunteerEntity.setVolName("wuhao11");
        volunteerEntity.setVolPassword("123456");
        volunteerEntity.setVolId("99");

        int rowsInserted = volunteerEntityMapper.insert(volunteerEntity);

        assert rowsInserted == 1;

    }

    }


