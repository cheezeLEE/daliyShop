package com.shopping.daliyShop.user.service;

import com.shopping.daliyShop.config.SHA512;
import com.shopping.daliyShop.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int idCheck(String usrId){
        int result = userMapper.idCheck(usrId);
        return result;
    }

    public int join(HashMap<String, Object> map) throws Exception {
        String pwd = map.get("usrPw").toString();
        String hashPwd = SHA512.encrypt(pwd);
        System.out.println("hashPwd = " + hashPwd);
        map.put("usrPw", hashPwd);
        System.out.println("hashPw = " + map.get("usrPw"));
        int join = userMapper.join(map);
        int joinAuth = userMapper.joinAuth(map);
        if(join == 1 && joinAuth == 1){
            return join;
        } else{
            throw new Exception("회원가입 실패");
        }
    }
}
