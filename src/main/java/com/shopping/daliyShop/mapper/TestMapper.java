package com.shopping.daliyShop.mapper;

import com.shopping.daliyShop.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ComponentScan;

@Mapper
public interface TestMapper {
    TestModel selectByIdTest(String id);
}