package com.imooc.controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.form.SellerInfoForm;
import com.imooc.service.SellerService;
import com.imooc.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RequestMapping("/seller")
@Controller
public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("sellerUser/index");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid SellerInfoForm sellerInfoForm,
                      BindingResult bindingResult,
                      HttpServletResponse response,
                      Map<String,Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/index");
            return new ModelAndView("common/error", map);
        }
        SellerInfo sellerInfo = sellerService.findByUsername(sellerInfoForm.getUsername());
        if (sellerInfo == null) {
            map.put("msg", "账号不存在");
            map.put("url", "/sell/seller/index");
            return new ModelAndView("common/error", map);
        }
        if (!sellerInfo.getPassword().equals(sellerInfoForm.getPassword())) {
            map.put("msg", "密码不正确");
            map.put("username", sellerInfoForm.getUsername());
            map.put("url", "/sell/seller/index?username="+sellerInfoForm.getUsername());
            return new ModelAndView("common/error", map);
        }
        //保存token到redis
        String token = UUID.randomUUID().toString().replace("-","");
        Integer expire = RedisConstant.EXPIRE; //设置时间7200秒（2小时）
        stringRedisTemplate.opsForValue()
                .set(String.format(RedisConstant.TOKEN_PREFIX,token),sellerInfo.getUsername()
                        ,expire, TimeUnit.SECONDS);//SECONDS:秒
        //保存token到cookie
        CookieUtil.set(response,CookieConstant.TOKEN,token,expire);

        return new ModelAndView("redirect:"+projectUrlConfig.getSell()
                +"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object> map) {
        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis
            stringRedisTemplate.opsForValue().getOperations()
                    .delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMassage());
        map.put("url","/sell/seller/index");
        return new ModelAndView("common/success", map);
    }
}
