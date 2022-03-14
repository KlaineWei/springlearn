package com.example.jwt.service;

import java.util.HashMap;
import java.util.Map;
import com.example.jwt.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class jwtServiceImpl implements jwtService{

    @Override
    public Map<String, Object> login() {
        String username = "weizihan";
        String token = JWTUtil.createToken(username);
        Map<String, Object> map = new HashMap<>();
        map.put("user", username);
        map.put("token", token);
        return map;
    }
}
