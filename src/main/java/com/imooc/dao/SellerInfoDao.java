package com.imooc.dao;

import com.imooc.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsernameAndPassword(String username,String password);

    SellerInfo findByUsername(String username);
}
