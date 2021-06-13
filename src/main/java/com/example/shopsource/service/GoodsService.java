package com.example.shopsource.service;

import com.example.shopsource.entity.po.Goods;
import com.example.shopsource.entity.po.SysUser;

import java.util.List;

/**
 * 商品管理的业务层
 */
public interface GoodsService {

    /**
     * 根据某用户（卖方）查询
     *
     * @param sysUser
     * @return
     */
    List<Goods> listGoods(SysUser sysUser);

    /**
     * 查询所有商品
     *
     * @return
     */
    List<Goods> listAllGoods();

    /**
     * 保存一个商品（新增OR修改）
     *
     * @param goods 商品对象
     * @param seller    卖方
     */
    void saveOneGoods(Goods goods, SysUser seller);

    /**
     * 查询获取一个商品信息（编辑前查询用）
     *
     * @param goodsId 商品id
     * @return
     */
    Goods getOneGoods(Long goodsId);

    /**
     * 扫描统计数+1
     * @param goodsId
     */
    void scanCountPlus(Long goodsId);
}
