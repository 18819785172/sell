package com.imooc.dao;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("乔装打扮（半只鸡）");
        productInfo.setProductPrice(new BigDecimal(9.9));
        productInfo.setProductStock(8);
        productInfo.setProductDescription("嘎嘣脆");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductId("123");
        productInfo.setCategoryType(9);
        ProductInfo info = dao.save(productInfo);
        Assert.assertNotNull(info);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = dao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}