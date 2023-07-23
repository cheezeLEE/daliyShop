package com.shopping.daliyShop.service;

import com.shopping.daliyShop.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService implements UserDetailsService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    /* 로그인 */
//    public HashMap<String, Object> login(HashMap<String, Object> map){
//        System.out.println("LoginService.login");
//        return loginMapper.login(map);
//    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserVO user = loginMapper.getAccount(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        user.setAuthList(loginMapper.getAuth(user.getUsrNo()));

        return user;
    }

    /* 아이디 찾기 */
    public String searchId(HashMap<String, Object> map){
        System.out.println("LoginService.searchId");
        return loginMapper.searchId(map);
    }

    /* 비밀번호 재설정 */
    public int searchPw(HashMap<String, Object> map){
        System.out.println("LoginService.searchPw");
        return loginMapper.searchPw(map);
    }
}
