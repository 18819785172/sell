package com.imooc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @param <T>
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -8349181922768084604L;

    private Integer code;   //错误码

    private String msg;     //提示信息

    private T data;         //具体内容
}
