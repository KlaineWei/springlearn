package com.example.emsjsp.dao;

import com.example.emsjsp.entity.User;

public interface UserDao {


    User findByUserName(String username);

    void save(User user);
}
