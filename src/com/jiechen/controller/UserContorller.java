package com.jiechen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserContorller {

    @RequestMapping("tologin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String login(@RequestParam(value = "username") String name, String password, HttpSession session) {
        // 校验用户登录状态
        System.out.println("name -> " + name + "; password -> " + password);

        session.setAttribute("username", name);

        return "redirect:/item/itemlist.action";
    }
}
