package com.example.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwt.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("fsf", "wsfe");
        map.put("gfdg", "wwegsfe");
        String token = JWTUtil.createToken(map);
        System.out.println(token);
//        DecodedJWT vtoken = JWTUtil.validateToken(token);
//        System.out.println(vtoken);
//        if (vtoken == null || vtoken.equals("")){
//            System.out.println("test token验证失败");
//        }

    }


}
