package com.imooc.service.impl;

import com.imooc.dao.ProductCategoryDao;
import com.imooc.dao.ProductInfoDao;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao categoryDao;
    @Autowired
    private ProductInfoDao infoDao;
    @Autowired
    private ProductService productService;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryDao.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory,Integer oldCategoryType) {
        if (oldCategoryType != null) {
            List<ProductInfo> infoList = infoDao.findByCategoryType(oldCategoryType);
            for (ProductInfo productInfo : infoList) {
                productInfo.setCategoryType(productCategory.getCategoryType());
                productService.save(productInfo);
            }
        }
        return categoryDao.save(productCategory);
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        return categoryDao.findByCategoryType(categoryType);
    }
}
