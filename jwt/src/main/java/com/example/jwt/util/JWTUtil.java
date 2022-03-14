package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTUtil {

    public static Map<String, Object> header;

    public static String secret;

    public static Long expireTime;

    public static String tokenPrefix;

    public static String USER_LOGIN_TOKEN = "Authorization";

    public void setHeader(Map<String, Object> header) {
        JWTUtil.header = header;
    }

    public void setSecret(String secret) {
        JWTUtil.secret = secret;
    }

    public void setExpireTime(Long expireTime) {
        JWTUtil.expireTime = expireTime;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTUtil.tokenPrefix = tokenPrefix;
    }

    public static String createToken(String subject){
        System.out.println("createToken...........");
//        System.out.println(header);
//        System.out.println(secret);
//        System.out.println(expireTime);
//        System.out.println(tokenPrefix);
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expireTime * 1000);
        System.out.println(expireDate);

        return JWT.create()
                .withHeader(header)
                .withSubject(subject)
                .withIssuedAt(nowDate)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public static String validateToken(String token) throws Exception {
        System.out.println("validateToken...........");
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getSubject();
        } catch (TokenExpiredException e){
            return  "validate token 已经过期！！";
        } catch (Exception e){
            return  "validate token验证失败";
        }
    }

    public static boolean isNeedUpdate(String token) throws Exception {
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getExpiresAt();
        } catch (TokenExpiredException e){
            return true;
        } catch (Exception e){
            System.out.println("update token验证失败");
        }
        //如果剩余过期时间少于过期时常的一半时 需要更新
        return (expiresAt.getTime()-System.currentTimeMillis()) < (expireTime>>1);
    }


}
