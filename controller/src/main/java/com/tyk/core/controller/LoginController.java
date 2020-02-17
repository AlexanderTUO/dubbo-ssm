package com.tyk.core.controller;

import com.tyk.core.sys.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }


    @RequestMapping("/userLogin")
    @ResponseBody
    public Map login(User user, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        Map result = new HashMap();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            User user1 = (User) subject.getPrincipal();
            session.setAttribute("user", user1);
            result.put("messege", true);
            return new HashMap();
        } catch (Exception e) {
            return null;
        }
    }
}
