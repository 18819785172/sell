package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class CartDTO {

    private String productId;           //商品Id

    private Integer productQuantity;    //数量

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
