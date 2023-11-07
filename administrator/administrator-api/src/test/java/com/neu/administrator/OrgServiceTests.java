package com.neu.administrator;

import com.neu.administrator.service.OrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName OrgServiceTests
 * @Description TODO
 * @Author CY
 * @Date 2023/11/7 14:16
 * @Version 1.0
 */
@SpringBootTest
public class OrgServiceTests {
    @Autowired
    OrgService orgService;

    @Test
    void passQualificationApplyTest(){
        orgService.passQualificationApply("2");
    }
}
