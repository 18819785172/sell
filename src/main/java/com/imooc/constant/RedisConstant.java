package com.imooc.constant;

public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    String TOKENS_PREFIX = "token_*";

    Integer EXPIRE = 7200;  //2小时
}
