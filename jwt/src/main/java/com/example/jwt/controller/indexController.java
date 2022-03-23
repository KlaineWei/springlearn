package com.example.jwt.controller;

import com.example.jwt.service.jwtService;
import com.example.jwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class indexController {

    @Autowired
    private jwtService jwtService;

    @GetMapping("/index")
    public String index(HttpServletResponse response){

//        return response.getHeader(JWTUtil.USER_LOGIN_TOKEN);
        return "This is index";
    }

    @GetMapping("/login")
    public Map<String, Object> login(HttpServletResponse response) {
        Map<String, Object> map = jwtService.login();
//        response.setHeader(JWTUtil.USER_LOGIN_TOKEN, (String) map.get("token"));
        System.out.println(map);
        return map;
    }
}
