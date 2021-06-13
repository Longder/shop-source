package com.example.shopsource.dao;

import com.example.shopsource.entity.po.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

    /**
     * 根据卖方id查询商品集合
     */
    @Select("SELECT * FROM GOODS WHERE seller_id=#{sellerId}")
    @ResultMap("com.example.shopsource.dao.GoodsDao.GoodsResultMap")
    List<Goods> findBySellerId(Long sellerId);

    /**
     * 查询所有商品
     */
    @Select("SELECT * FROM GOODS")
    @ResultMap("com.example.shopsource.dao.GoodsDao.GoodsResultMap")
    List<Goods> findAll();

    /**
     * 新增一个商品入库
     *
     * @param goods
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO goods(NAME, DEALER, FACTORY, UNIT_PRICE, IMAGE, QR_CODE_IMAGE, SCAN_COUNT, SELLER_ID) VALUES(#{name},#{dealer},#{factory},#{unitPrice},#{image},#{qrCodeImage},#{scanCount},#{sellerId})")
    void insert(Goods goods);

    /**
     * 根据id查询一个
     *
     * @param goodsId
     */
    @Select("SELECT * FROM GOODS WHERE id=#{goodsId}")
    @ResultMap("com.example.shopsource.dao.GoodsDao.GoodsResultMap")
    Goods getOne(Long goodsId);

    /**
     * 更新一个商品
     *
     * @param goods
     */
    @Update("UPDATE goods SET name = #{name},dealer = #{dealer},factory = #{factory},UNIT_PRICE = #{unitPrice},image = #{image} where id = #{id}")
    void update(Goods goods);

    /**
     * 更新商品的二维码图片
     *
     * @param goods
     */
    @Update("UPDATE goods SET qr_code_image = #{qrCodeImage} where id = #{id}")
    void updateQrCodeImage(Goods goods);

}
