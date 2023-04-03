package com.shopping.daliyShop.service;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public TestModel selectByNo(int usrNo){
        return testMapper.selectByNo(usrNo);
    }

    public List<TestModel> findAll() {
        return testMapper.findAll();
    }

    public int insert(TestModel testModel){
        return testMapper.insert(testModel);
    }
}
