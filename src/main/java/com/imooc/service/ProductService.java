package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String ProductId);

    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品并分页
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //将库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
