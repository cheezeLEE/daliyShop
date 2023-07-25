package com.shopping.daliyShop.test.service;

import com.shopping.daliyShop.config.SHA512;
import com.shopping.daliyShop.test.mapper.TestMapper;
import com.shopping.daliyShop.test.model.TestModel;
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
        /* 비밀번호 암호화 */
        String encodePw = SHA512.encrypt(testModel.getUsrPw());
        testModel.setUsrPw(encodePw);
        return testMapper.insert(testModel);
    }

    public TestModel selectById(String usrId) throws Exception{
        return testMapper.selectById(usrId);
    }
}
