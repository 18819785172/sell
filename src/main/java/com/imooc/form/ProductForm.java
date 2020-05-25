package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

    private String productId;

    private String productName;         //商品名称

    private BigDecimal productPrice;    //商品价格

    private Integer productStock;       //库存

    private String productDescription; //商品描述

    private String productIcon;        //商品小图

    private Integer categoryType;      //类目编号
}
