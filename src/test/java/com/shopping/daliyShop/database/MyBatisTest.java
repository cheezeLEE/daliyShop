package com.shopping.daliyShop.database;

import com.shopping.daliyShop.model.TestModel;
import com.shopping.daliyShop.service.TestService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private TestService testService;

    @Test
    void selectTest(){
        TestModel testModel = testService.selectByNo(1);
        Assertions.assertThat(testModel.getUsrId()).isEqualTo("id");
    }

    @Test
    void findAllTest(){
        List<TestModel> all = testService.findAll();
        Assertions.assertThat(all.get(1).getUsrId()).isEqualTo("testId");
    }

    @Test
    void insertTest(){
        TestModel testModel = new TestModel();
        testModel.setUsrId("testId");
        testModel.setUsrPw("testPw");
        testModel.setUsrName("testUsrName");
        testService.insert(testModel);
    }
}
