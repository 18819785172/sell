package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mpAppIdPro;

    private String openIdPro;

    private String mchId;       //商户号

    private String mchKey;      //商户秘钥

    private String keyPath;     //商户证书路劲

    private String notifyUrl;   //微信支付异步通知地址
}
