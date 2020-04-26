package com.imooc.dao;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired(required = false)
    private ProductCategoryDao dao;

    @Test
    public void findById(){
        Optional<ProductCategory> productCategory = dao.findById(1);
        ProductCategory productCategory1 = productCategory.get();
        System.out.println(productCategory1);
    }

    @Test
//    @Transactional
    public void save(){
        ProductCategory productCategory = new ProductCategory("测试",7);
        ProductCategory result = dao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4,5);
        List<ProductCategory> result = dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}