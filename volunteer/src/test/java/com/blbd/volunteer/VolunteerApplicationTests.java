package com.blbd.volunteer;

import com.blbd.volunteer.dao.VolunteerEntityMapper;
import com.blbd.volunteer.dao.entity.VolunteerEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = VolunteerApplication.class)
@RunWith(SpringRunner.class)
class VolunteerApplicationTests {

    private VolunteerEntityMapper volunteerEntityMapper ;

    @Test
    public void contextLoads() {

        VolunteerEntity volunteerEntity = new VolunteerEntity();

        volunteerEntity.setVolName("wuhao");
        volunteerEntity.setVolPassword("123456");
        volunteerEntityMapper.insert(volunteerEntity);

    }

}
