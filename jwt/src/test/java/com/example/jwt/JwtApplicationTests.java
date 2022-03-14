package com.example.jwt;

import com.example.jwt.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testToken() throws Exception {
        String token = JWTUtil.createToken("weizihan");
        System.out.println(token);
        String vtoken = JWTUtil.validateToken(token);
        System.out.println(vtoken);
        if (vtoken == null || vtoken.equals("")){
            System.out.println("test token验证失败");
        }

    }


}
