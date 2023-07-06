package com.shopping.daliyShop.service;

import com.shopping.daliyShop.config.SHA512;
import com.shopping.daliyShop.mapper.ProfileMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProfileService {

    private final ProfileMapper profileMapper;

    public ProfileService(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public int idCheck(String usrId){
        int result = profileMapper.idCheck(usrId);
        return result;
    }

    public int join(HashMap<String, Object> map) throws Exception {
        String pwd = map.get("usrPw").toString();
        String hashPwd = SHA512.encrypt(pwd);
        System.out.println("hashPwd = " + hashPwd);
        map.put("usrPw", hashPwd);
        System.out.println("hashPw = " + map.get("usrPw"));
        int join = profileMapper.join(map);
        int joinAuth = profileMapper.joinAuth(map);
        if(join == 1 && joinAuth == 1){
            return join;
        } else{
            throw new Exception("회원가입 실패");
        }
    }
}
