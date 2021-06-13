package com.example.shopsource.entity.po;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 商品实体
 */
@Data
public class Goods implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 经销商
     */
    private String dealer;
    /**
     * 生产地
     */
    private String factory;
    /**
     * 单价
     */
    private String unitPrice;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 二维码图片
     */
    private String qrCodeImage;
    /**
     * 扫描次数
     */
    private Integer scanCount = 0;
    /**
     * 买方id
     */
    private Long sellerId;

    /**
     * 上传的商品图片
     */
    private MultipartFile imageFile;
}
