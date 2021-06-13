package com.example.shopsource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * 主页
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 登录页
     */
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 后台管理主页
     */
    @GetMapping("/admin/index")
    public String adminIndex() {
        return "adminIndex";
    }
}
