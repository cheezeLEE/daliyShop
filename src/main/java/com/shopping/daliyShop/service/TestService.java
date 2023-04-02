package com.shopping.daliyShop.service;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public TestModel selectByNo(int usrNo){
        return testMapper.selectByNo(usrNo);
    }

    public TestModel findAll() {
        return testMapper.findAll();
    }
}
