package com.shopping.daliyShop.mapper;

import com.shopping.daliyShop.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    TestModel selectByNo(int usrNo);
    TestModel findAll();
}
