package com.cn.why.entity;

import lombok.Data;

@Data
public class News extends Base{
    private String name;
    private String englishName;
    private String img;
    private String type;
    private String href;
    private String detail;
}
