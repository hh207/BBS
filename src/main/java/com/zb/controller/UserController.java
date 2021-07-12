package com.zb.controller;

import com.zb.entity.User;
import com.zb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/loginInit")
    public String loginInit(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){
        try {
            User user1 = userService.login(user);
            session.setAttribute("user", user1);
            model.addAttribute("msg", "登录成功！");
            return "redirect:comment";
        }catch (RuntimeException e){
            model.addAttribute("msg", e.getMessage());
            return "login";
        }
    }
}
