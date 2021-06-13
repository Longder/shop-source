package com.example.shopsource.controller;

import com.example.shopsource.config.SecurityUtil;
import com.example.shopsource.entity.po.Goods;
import com.example.shopsource.entity.po.SysUser;
import com.example.shopsource.entity.vo.Response;
import com.example.shopsource.service.GoodsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/goods")
public class GoodsManageController {
    @Resource
    private GoodsService goodsService;

    /**
     * 商品列表，卖家只能查到自己的商品
     */
    @GetMapping("/list")
    public Response list() {
        SysUser currentUser = SecurityUtil.getCurrentUser();
        return Response.success(goodsService.listGoods(currentUser));
    }

    /**
     * 添加商品
     */
    @PostMapping("/add")
    public Response add(Goods goods) {
        SysUser currentUser = SecurityUtil.getCurrentUser();
        goodsService.saveOneGoods(goods, currentUser);
        return Response.success("添加成功");
    }


    /**
     * 修改商品
     */
    @PostMapping("/update")
    public Response update(Goods goods) {
        SysUser currentUser = SecurityUtil.getCurrentUser();
        goodsService.saveOneGoods(goods, currentUser);
        return Response.success("修改成功");
    }

    /**
     * 商品详情
     *
     * @return
     */
    @GetMapping("/detail")
    public Response detail(Long id) {
        return Response.success(goodsService.getOneGoods(id));
    }
}
