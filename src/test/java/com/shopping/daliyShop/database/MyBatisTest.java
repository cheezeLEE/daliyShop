package com.shopping.daliyShop.database;

import com.shopping.daliyShop.model.TestModel;
import com.shopping.daliyShop.service.TestService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private TestService testService;

    @Test
    void selectTest(){
        TestModel testModel = testService.selectByNo(1);
        System.out.println(testModel.toString());

    }

    @Test
    void findAllTest(){
        TestModel all = testService.findAll();
        Assertions.assertThat(all.getUsrNo()).isEqualTo(1);
    }
}
