package com.imooc.dao;

import com.imooc.dataobject.ProductInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByCategoryType(Integer categoryType);

    @CacheEvict(cacheNames = {"product1","product2"},key = "123")
    ProductInfo save(ProductInfo productInfo);
}
