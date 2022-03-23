package com.example.mybatisx.mapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


import com.alibaba.fastjson.JSONObject;
import com.example.mybatisx.entity.Family;
import com.example.mybatisx.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
* @author weizihan
* @description 针对表【users】的数据库操作Mapper
* @createDate 2022-03-07 09:40:20
* @Entity com.example.mybatisX.entity.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    Users selectOneById(@Param("id") Object id);

    List<Users> selectAll();

    List<Users> getAllFamilyInfo();

    List<Users> getFigureInfo();

    int insertBatch(@Param("usersCollection") Collection<Users> usersCollection);

    List<JSONObject> getAllFamily();

}




