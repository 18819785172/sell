package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);

    SellerInfo findByUsernameAndPassword(String username,String password);

    SellerInfo findByUsername(String username);
}
