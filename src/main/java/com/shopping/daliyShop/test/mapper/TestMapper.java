package com.shopping.daliyShop.test.mapper;

import com.shopping.daliyShop.test.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    TestModel selectByNo(int usrNo);
    List<TestModel> findAll();
    int insert(TestModel testModel);

    TestModel selectById(String usrId);
}
