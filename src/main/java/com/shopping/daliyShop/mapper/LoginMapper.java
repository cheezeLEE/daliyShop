package com.shopping.daliyShop.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface LoginMapper {

    /* 로그인 */
    HashMap<String, Object> login(HashMap<String, Object> map);

    /* 아이디 찾기 */
    String searchId(HashMap<String, Object> map);

    /* 비밀번호 재설정 */
    int searchPw(HashMap<String, Object> map);
}
