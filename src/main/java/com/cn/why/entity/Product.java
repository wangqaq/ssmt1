package com.cn.why.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product extends Base {
    private BigDecimal marketPrice;
    private BigDecimal normalPrice;
    private String name;
    private String content;
    private String imgHref;
    private Integer isTop;
    private Integer isHot;
    private Integer enable;
    private String detail;
    private String serviceEnglishName;
    private String type;
}
