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
        Map<String, Object> map1 = new HashMap<>();
        map1.put("fsf", "wsfe");
        map1.put("gfdg", "wwegsfe");
        String token = JWTUtil.createToken(map1);
        Map<String, Object> map = new HashMap<>();
        map.put("user", map1);
        map.put("token", token);
        return map;
    }
}
