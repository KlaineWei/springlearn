package com.example.mybatisx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisx.entity.Users;
import com.example.mybatisx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UsersService usersService;

    @Value("${page.pageSize}")
    private Integer pageSize;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Integer id){

        return usersService.selectOneById(id);
    }

    @GetMapping
    public List<Users> selectAll(){
        return usersService.selectAll();
    }

//    @PatchMapping ("/gender/{id}")
//    public void updateGenderById(@PathVariable("id") Integer id, @RequestBody String gender){
//        usersService.updateGenderById(gender, id);
//    }

    @GetMapping("/page/{id}")
    public Page<Users> getPage(@PathVariable("id") Integer id){
        return usersService.selectPage(id, pageSize);
    }

    @GetMapping("/family")
    public List<Users> getAllFamilyInfo(){
        return usersService.getAllFamilyInfo();
    }

}
