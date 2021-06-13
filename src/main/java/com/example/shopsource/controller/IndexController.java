package com.example.shopsource.controller;

import com.example.shopsource.entity.vo.Response;
import com.example.shopsource.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private GoodsService goodsService;

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

    @ResponseBody
    @GetMapping("/listAllGoods")
    public Response listAllGoods() {
        return Response.success(goodsService.listAllGoods());
    }
}
