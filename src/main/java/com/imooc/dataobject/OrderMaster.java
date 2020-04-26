package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
@Entity
@Data
@DynamicUpdate
@Proxy(lazy=false)
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;       //买家名字

    private String buyerPhone;      //买家电话

    private String buyerAddress;    //买家地址

    private String buyerOpenid;     //买家微信openid

    private BigDecimal orderAmount; //订单总金额

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();    //订单状态, 默认0新下单

    private Integer payStatus = PayStatusEnum.WAIT.getCode();      //支付状态, 默认0未支付

    private Date createTime;            //创建时间

    private Date updateTime;            //修改时间
}
