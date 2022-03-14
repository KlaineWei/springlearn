//package com.example.jwt.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.Date;
//import java.util.Map;
//
//@Component
//@Validated
//@ConfigurationProperties(prefix = "jwt.itmanage")
//public class JWTUtil {
//
//    public static Map<String, Object> header;
//
//    public static String secret;
//
//    public static Long expireTime;
//
//    public static String tokenPrefix;
//
//    public static String USER_LOGIN_TOKEN = "Authorization";
//
//    public void setHeader(Map<String, Object> header) {
//        JWTUtil.header = header;
//    }
//
//    public void setSecret(String secret) {
//        JWTUtil.secret = secret;
//    }
//
//    public void setExpireTime(Long expireTime) {
//        JWTUtil.expireTime = expireTime;
//    }
//
//    public void setTokenPrefix(String tokenPrefix) {
//        JWTUtil.tokenPrefix = tokenPrefix;
//    }
//
//    public static String createToken(Map<String, Object> payload){
//        System.out.println("createToken...........");
////        System.out.println(header);
////        System.out.println(secret);
////        System.out.println(expireTime);
////        System.out.println(tokenPrefix);
//        Date nowDate = new Date();
//        Date expireDate = new Date(nowDate.getTime() + expireTime * 1000 * 60);
//        System.out.println(expireDate);
//
//        return tokenPrefix + JWT.create()
//                .withHeader(header)
//                .withIssuedAt(nowDate)
//                .withExpiresAt(expireDate)
//                .withClaim("userinfo",payload)
//                .sign(Algorithm.HMAC256(secret));
//    }
//
//    public static DecodedJWT validateToken(String token) throws Exception {
//        System.out.println("validateToken...........");
//        //如果token无效
//        if (token == null || "".equals(token)) {
//            throw new JWTDecodeException("token为空！");
//        }
//
//        // 解析token
//        DecodedJWT verify = null;
//        try {
//            verify = JWT.require(Algorithm.HMAC256(secret))
//                    .build()
//                    .verify(token.replace(tokenPrefix, ""));
//        } catch (Exception e){
//            throw new JWTDecodeException("validate token验证失败");
//        }
//
//        return verify;
//    }
//
//    public static boolean isNeedUpdate(String token) throws Exception {
//        //获取token过期时间
//        Date expiresAt = null;
//        try {
//            expiresAt = JWT.require(Algorithm.HMAC256(secret))
//                    .build()
//                    .verify(token.replace(tokenPrefix, ""))
//                    .getExpiresAt();
//        } catch (TokenExpiredException e){
//            return true;
//        } catch (Exception e){
//            System.out.println("update token验证失败");
//        }
//        //如果剩余过期时间少于过期时常的一半时 需要更新
//        return (expiresAt.getTime()-System.currentTimeMillis()) < (expireTime>>1);
//    }
//
//
//}
package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.Map;

@Component
@Validated
@ConfigurationProperties(prefix = "jwt.itmanage")
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

    public static String createToken(Map<String, Object> payload){
        System.out.println("createToken...........");
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expireTime * 1000 * 60);
        System.out.println("expireDate:" + expireDate);

        return tokenPrefix + JWT.create()
                .withHeader(header)
                .withIssuedAt(nowDate)
                .withExpiresAt(expireDate)
                .withClaim("userinfo", payload)
                .sign(Algorithm.HMAC256(secret));
    }

    public static DecodedJWT validateToken(String token) throws Exception {
        System.out.println("validateToken...........");
        //如果token无效
        if (token == null || "".equals(token)) {
            throw new JWTDecodeException("token为空！");
        }

        String ntoken = token.replace(tokenPrefix, "");
        System.out.println(ntoken);

        // 解析token
        DecodedJWT verify = null;
        try {
            verify = JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""));
        } catch (Exception e){
            throw new JWTDecodeException("validate token验证失败");
        }

        return verify;
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
