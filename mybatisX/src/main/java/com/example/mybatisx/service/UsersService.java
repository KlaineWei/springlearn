package com.example.mybatisx.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisx.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
* @author weizihan
* @description 针对表【users】的数据库操作Service
* @createDate 2022-03-07 09:40:20
*/
public interface UsersService extends IService<Users> {

    Users selectOneById(Integer id);

    List<Users> selectAll();

    Page<Users> selectPage(Integer id, Integer size);

    List<Users> getAllFamilyInfo();

    List<Users> getFigureInfo();

    int insertBatch(Collection<Users> usersCollection);

    List<JSONObject> getAllFamily();
}
