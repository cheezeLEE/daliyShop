package com.shopping.daliyShop.service;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestMapper testMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TestService(TestMapper testMapper, PasswordEncoder passwordEncoder) {
        this.testMapper = testMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public TestModel selectByNo(int usrNo){
        return testMapper.selectByNo(usrNo);
    }

    public List<TestModel> findAll() {
        return testMapper.findAll();
    }

    public int insert(TestModel testModel){
        /* 비밀번호 암호화 */
        String encodePw = passwordEncoder.encode(testModel.getUsrPw());
        testModel.setUsrPw(encodePw);
        return testMapper.insert(testModel);
    }

    public TestModel selectById(String usrId) throws Exception{
        return testMapper.selectById(usrId);
    }
}
