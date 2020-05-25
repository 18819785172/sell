package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 手动获取openid的方法
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code) {
        log.info("进入auth方法...");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=wx13afafa4ccb3cf6a&secret=382777e59df37ff564dd3831afdca485" +
                "&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }


}
