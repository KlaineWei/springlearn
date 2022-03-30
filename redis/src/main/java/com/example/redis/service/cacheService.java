package com.example.redis.service;

import com.example.redis.entity.User;

import java.util.List;

public interface cacheService {

    public User getUser(Integer id);

    public List<User> getUserList();

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(Integer id);
}
