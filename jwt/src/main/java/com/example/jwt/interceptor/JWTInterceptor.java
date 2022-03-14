package com.example.jwt.interceptor;

import com.example.jwt.util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle..............");

        //从请求头内获取token
        String token = response.getHeader(JWTUtil.USER_LOGIN_TOKEN);
        System.out.println("token:" + token);


        if (token == null || token.equals("")) {
            System.out.println("请先登录！！！");
            response.sendRedirect(request.getContextPath() + "/login");
        }

        String sub = JWTUtil.validateToken(token);
        System.out.println("sub:" + sub);
        if (sub == null || sub.equals("")){
            System.out.println("prehandler token验证失败");
            response.sendRedirect(request.getContextPath() + "/login");
        }

        if (JWTUtil.isNeedUpdate(token)){
            String newToken = JWTUtil.createToken(sub);
            response.setHeader(JWTUtil.USER_LOGIN_TOKEN, newToken);
        }

        return true;
    }
}
