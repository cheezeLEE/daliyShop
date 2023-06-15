package com.shopping.daliyShop.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface LoginMapper {

    /* 로그인 */
    HashMap<String, Object> login(HashMap<String, Object> map);
}
