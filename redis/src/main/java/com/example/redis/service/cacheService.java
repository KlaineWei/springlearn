package com.example.redis.service;

import com.example.redis.entity.User;

import java.util.List;

public interface cacheService {

    public User getUser(Integer id);

    public List<User> getUserList();

    public User addUser(User user);

    public List<User> addUserList(Integer id, List<User> userList);

    public User updateUser(User user);

    public void deleteUser(Integer id);
}
