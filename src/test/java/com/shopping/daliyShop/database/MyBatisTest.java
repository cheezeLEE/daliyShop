package com.shopping.daliyShop.database;

import com.shopping.daliyShop.config.SHA512;
import com.shopping.daliyShop.test.model.TestModel;
import com.shopping.daliyShop.test.service.TestService;
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
        Assertions.assertThat(all.get(1).getUsrId()).isEqualTo("user");
    }

    @Test
    void insertTest(){
        /* security를 통해 가입한 것이 아니라 로그인이 안되는것같음 */
        TestModel testModel = new TestModel();
        testModel.setUsrId("testId");
        testModel.setUsrPw(SHA512.encrypt("testPw"));
        testModel.setUsrName("testUsrName");
        testModel.setRoles("USER");
        testService.insert(testModel);
    }
}
