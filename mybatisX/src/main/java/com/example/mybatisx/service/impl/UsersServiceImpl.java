package com.example.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisx.entity.Users;
import com.example.mybatisx.service.UsersService;
import com.example.mybatisx.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author weizihan
* @description 针对表【users】的数据库操作Service实现
* @createDate 2022-03-07 09:40:20
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    private UsersMapper usersMapper;

    @Autowired(required = false)
    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Users selectOneById(Integer id){
        return usersMapper.selectOneById(id);
    }

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public Page<Users> selectPage(Integer id, Integer size) {
        Page<Users> page = new Page<>(id, size);
        return usersMapper.selectPage(page, null);
    }

    @Override
    public List<Users> getAllFamilyInfo() {
        return usersMapper.getAllFamilyInfo();
    }
}




