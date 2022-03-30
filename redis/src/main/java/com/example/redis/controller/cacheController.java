package com.example.redis.controller;

import com.example.redis.entity.User;
import com.example.redis.service.cacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class cacheController {

    @Autowired
    private cacheService service;

    @GetMapping("getUser")
    public User getUser(Integer id){
        return service.getUser(id);
    }

    @GetMapping("getUserList")
    public List<User> getUserList(){
        return service.getUserList();
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        service.addUser(user);
        return user;
    }

    @PostMapping("updateUser")
    public User updateUser(@RequestBody User user){
        service.updateUser(user);
        return user;
    }

    @PostMapping("deleteUser")
    public String deleteUser(Integer id){
        service.deleteUser(id);
        return "删除成功";
    }
}
