package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Proxy(lazy=false)
public class ProductInfo {

    @Id
    private String productId;

    private String productName;         //商品名称

    private BigDecimal productPrice;    //商品价格

    private Integer productStock;       //库存

    private String productDescription; //商品描述

    private String productIcon;        //商品小图

    private Integer productStatus;      //商品状态，0正常1下架

    private Integer categoryType;      //类目编号

}
