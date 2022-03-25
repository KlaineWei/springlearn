package com.example.mapstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mapStructController {

    @GetMapping("user")
    public User getUser(){

        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("weizihan");

        User user = UserConvert.INSTANCE.convert(userVo);
        return user;

    }
}
