package com.neu.administrator;

import com.neu.administrator.service.ChildService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ChildServiceTests
 * @Description TODO
 * @Author CY
 * @Date 2023/11/7 14:10
 * @Version 1.0
 */
@SpringBootTest
public class ChildServiceTests {
    @Autowired
    ChildService childService;

    @Test
    void passQualificationApplyTest(){
        childService.passQualificationApply("1");
    }
}
