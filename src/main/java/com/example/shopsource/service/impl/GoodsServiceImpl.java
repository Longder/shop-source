package com.example.shopsource.service.impl;

import com.example.shopsource.dao.GoodsDao;
import com.example.shopsource.entity.po.Goods;
import com.example.shopsource.entity.po.SysUser;
import com.example.shopsource.service.GoodsService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;


/**
 * 商品管理的业务层
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 根据某用户（卖方）查询
     */
    @Override
    public List<Goods> listGoods(SysUser sysUser) {
        return goodsDao.findBySellerId(sysUser.getId());
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @Override
    public List<Goods> listAllGoods() {
        return goodsDao.findAll();
    }

    /**
     * 保存一个商品（新增OR修改）
     *
     * @param goods  商品对象
     * @param seller 卖方
     */
    @Override
    @Transactional
    public void saveOneGoods(Goods goods, SysUser seller) {
        if (ObjectUtils.isEmpty(goods.getId())) {//新增
            //图片转为base64
            try {
                goods.setImage("data:image/jpeg;base64," + DatatypeConverter.printBase64Binary(goods.getImageFile().getBytes()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //记录卖家，当前用户
            goods.setSellerId(seller.getId());
            goodsDao.insert(goods);
            this.handleQrCode(goods);
        } else { // 修改
            Goods dbGoods = goodsDao.getOne(goods.getId());
            dbGoods.setName(goods.getName());
            dbGoods.setUnitPrice(goods.getUnitPrice());
            dbGoods.setDealer(goods.getDealer());
            dbGoods.setFactory(goods.getFactory());
            //上传了图片才修改图片
            if (!ObjectUtils.isEmpty(goods.getImageFile().getOriginalFilename())) {
                try {
                    dbGoods.setImage("data:image/jpeg;base64," + DatatypeConverter.printBase64Binary(goods.getImageFile().getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            goodsDao.update(goods);
        }
    }

    /**
     * 处理生成二维码
     */
    @SneakyThrows
    private void handleQrCode(Goods goods) {
        // 获取本地ip地址
        InetAddress address = InetAddress.getLocalHost();
        String url = String.format("http://%s:8090/GoodsInfo/%d", address.getHostAddress(), goods.getId());
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 500, 500);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(image, "png", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
        String qrImage = "data:image/jpeg;base64," + DatatypeConverter.printBase64Binary(bytes);
        goods.setQrCodeImage(qrImage);
        goodsDao.updateQrCodeImage(goods);
    }

    /**
     * 查询获取一个商品信息（编辑前查询用）
     *
     * @param goodsId 商品id
     * @return
     */
    @Override
    public Goods getOneGoods(Long goodsId) {
        return null;
    }

    /**
     * 扫描统计数+1
     *
     * @param goodsId
     */
    @Override
    public void scanCountPlus(Long goodsId) {

    }
}
