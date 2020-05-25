package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 微信模板信息推送
 */
public interface PushMassageService {

    void orderStatus(OrderDTO orderDTO);
}
