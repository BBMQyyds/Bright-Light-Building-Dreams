package com.blbd.children;

import com.blbd.children.mapper.ChildMapper;
import com.blbd.children.dao.entity.Child;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChildrenApplicationTests {

    @Autowired
    private ChildMapper childMapper;

    @Test
    void contextLoads() {
        List<Child> childrenList = childMapper.selectList(null);

        childrenList.forEach(System.out::println);
    }

}
