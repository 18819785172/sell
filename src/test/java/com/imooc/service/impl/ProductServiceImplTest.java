package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo productInfo = service.findOne("123");
        System.out.println(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = service.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("鸡腿汉堡");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("新鲜的鸡腿堡");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductId("456");
        productInfo.setCategoryType(9);
        ProductInfo info = service.save(productInfo);
        Assert.assertNotNull(info);
    }
}