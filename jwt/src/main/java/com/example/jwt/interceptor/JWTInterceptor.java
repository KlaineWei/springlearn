package com.example.jwt.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwt.util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle..............");
        System.out.println(request.getRequestURL());

        //从请求头内获取token
        String token = request.getHeader(JWTUtil.USER_LOGIN_TOKEN);
        System.out.println("token:" + token);


        if (token == null || token.equals("")) {
            System.out.println("请先登录！！！");
            response.sendRedirect(request.getContextPath() + "/login");
        }

        DecodedJWT dtoken = JWTUtil.validateToken(token);
        Claim claim = dtoken.getClaim("userinfo");
        Map<String, Object> map = claim.asMap();
        System.out.println("map:" + map);
        if (map == null || map.equals("")){
            System.out.println("prehandler token验证失败");
            response.sendRedirect(request.getContextPath() + "/login");
        }

        if (JWTUtil.isNeedUpdate(token)){
            String newToken = JWTUtil.createToken(map);
            response.setHeader(JWTUtil.USER_LOGIN_TOKEN, newToken);
        }

        return true;
    }
}
