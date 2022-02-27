package com.example.emsjsp.service;

import com.example.emsjsp.entity.User;

public interface UserService {

    void register(User user);

    User login(String username, String password);
}
