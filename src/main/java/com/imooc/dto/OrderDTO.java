package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.util.EnumUtil;
import com.imooc.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@DynamicUpdate
public class OrderDTO {

    private String orderId;

    private String buyerName;       //买家名字

    private String buyerPhone;      //买家电话

    private String buyerAddress;    //买家地址

    private String buyerOpenid;     //买家微信openid

    private BigDecimal orderAmount; //订单总金额

    private Integer orderStatus;    //订单状态, 默认0新下单

    private Integer payStatus;      //支付状态, 默认0未支付

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;            //创建时间

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;            //修改时间

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
