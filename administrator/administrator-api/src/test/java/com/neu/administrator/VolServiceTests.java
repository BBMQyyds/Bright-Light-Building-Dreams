package com.neu.administrator;

import com.neu.administrator.service.VolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName VolServiceTests
 * @Description TODO
 * @Author CY
 * @Date 2023/11/7 14:14
 * @Version 1.0
 */
@SpringBootTest
public class VolServiceTests {
    @Autowired
    VolService volService;

    @Test
    void passQualificationApplyTest(){
        volService.passQualificationApply("f869538ae91948b9ad8359f1c0663775");
    }


}
