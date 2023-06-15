package com.shopping.daliyShop.service;

import com.shopping.daliyShop.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public HashMap<String, Object> login(HashMap<String, Object> map){
        System.out.println("LoginService.login");
        return loginMapper.login(map);
    }
}
