package com.example.redis.service;

import com.example.redis.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class cacheServiceImpl implements cacheService {

    @Override
    @Cacheable(value = "user", key = "#id", unless="#result == null")
    public User getUser(Integer id) {
        System.out.println("========进来取数据了========");
        User user = new User();
        user.setId(1);
        user.setName("aa");
        user.setRealname("1号");
        return user;
    }

    @Override
    @Cacheable(value = "userlist", unless="#result == null")
    public List<User> getUserList() {
        System.out.println("========进来取数据了========");
        User user = new User();
        user.setId(1);
        user.setName("aa");
        user.setRealname("1号");
        User user2 = new User();
        user2.setId(2);
        user2.setName("bb");
        user2.setRealname("2号");
        User user3 = new User();
        user3.setId(3);
        user3.setName("cc");
        user3.setRealname("3号");
        List list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User addUser(User user) {
        System.out.println("========进来存数据了=======");
        return user;
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User updateUser(User user) {
        System.out.println("========进来修改数据了=======");
        return user;
    }

    @Override
    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(Integer id) {
        System.out.println("========进来删除数据了========");
    }

}
