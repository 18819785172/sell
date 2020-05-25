package com.imooc.form;

import lombok.Data;

@Data
public class CategoryForm {

    private Integer categoryId;

    private String categoryName;    //类目名称

    private Integer categoryType;   //类目编号
}
