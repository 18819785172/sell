package com.imooc.service.impl;

import com.imooc.dao.SellerInfoDao;
import com.imooc.dataobject.SellerInfo;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

    @Override
    public SellerInfo findByUsernameAndPassword(String username, String password) {
        return sellerInfoDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public SellerInfo findByUsername(String username) {
        return sellerInfoDao.findByUsername(username);
    }

}
