package com.shopping.daliyShop;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.assertj.core.api.Assertions;
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
        // mybatis를 통해 db에서 가져온 데이터
        TestModel testModel = testMapper.selectByIdTest("1");
        // TestModel 객체에 동일한 데이터를 넣어서 비교
        TestModel testModel1 = new TestModel();
        testModel1.setId("1");
        testModel1.setPw("1");
        testModel1.setName("테스트");
        Assertions.assertThat(testModel).isEqualTo(testModel1);
    }
}
