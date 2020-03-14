package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: 梦学谷
 */
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public String login (HttpSession session, String username, String password, Map<String, Object> map) {
        if(!StringUtils.isEmpty(username)
                &&!StringUtils.isEmpty(password)){
            User user = userMapper.getUserByUsername(username);
            if(user != null&&user.getPassword().equals(password)){
                session.setAttribute("loginUser",user);
                return "redirect:/main.html";
            }
        }
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //1. 清空session中的用户信息
        session.removeAttribute("loginUser");
        //2. 再将session进行注销
        session.invalidate();
        //3. 返回登录页面
        return "redirect:/index.html";
    }

}
