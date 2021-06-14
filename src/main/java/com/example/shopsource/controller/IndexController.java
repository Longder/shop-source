package com.example.shopsource.controller;

import com.example.shopsource.entity.vo.Response;
import com.example.shopsource.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    /**
     * 查询所有商品
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/listAllGoods")
    public Response listAllGoods() {
        return Response.success(goodsService.listAllGoods());
    }

    /**
     * 商品详情信息，扫码查看
     */
    @GetMapping("/GoodsInfo/{goodsId}")
    public String commodityInfo(@PathVariable Long goodsId,Model model) {
        goodsService.scanCountPlus(goodsId);
        model.addAttribute("goodsId",goodsId);
        return "goodsInfo";
    }

    @ResponseBody
    @GetMapping("/goodsDetails")
    public Response goodsDetail(Long id){
        return Response.success(goodsService.getOneGoods(id));
    }


}
