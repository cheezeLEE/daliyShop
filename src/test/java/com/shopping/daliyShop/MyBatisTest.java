package com.shopping.daliyShop;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void selectByIdTest(){
        TestModel testModel = testMapper.selectByIdTest("1");
        System.out.println("testModel = " + testModel.toString());
    }
}
