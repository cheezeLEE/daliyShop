package com.shopping.daliyShop.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UserMapper {

    int idCheck(String usrId);
    int join(HashMap<String, Object> map);
    int joinAuth(HashMap<String, Object> map);


}
