package com.example.emsjsp.controller;

import com.example.emsjsp.entity.User;
import com.example.emsjsp.service.UserService;
import com.example.emsjsp.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) throws UnsupportedEncodingException {

        log.debug("接收到的用户名:{}, 接收到的密码:{}", username, password);
        try {
            User user = userService.login(username, password);
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login.jsp?msg=" + URLEncoder.encode(e.getMessage(), "UTF-8");
        }
        return "redirect:/emplist.jsp";

    }

    @RequestMapping("register")
    public String register(User user, String code, HttpSession session) throws UnsupportedEncodingException {
        log.debug("用户姓名:{}", user.getUsername() );
        log.debug("用户密码:{}", user.getPassword() );
        log.debug("用户真名:{}", user.getRealname() );
        log.debug("用户性别:{}", user.getGender() );
        log.debug("验证码:{}", code );

        try {
            String genCode = session.getAttribute("code").toString();
            if(!genCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误！");
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/regist.jsp?msg=" + URLEncoder.encode(e.getMessage(),"UTF-8");
        }

        return "redirect:/login.jsp";
    }

    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        String code = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("code", code);
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(120,40,os,code);
    }


}
