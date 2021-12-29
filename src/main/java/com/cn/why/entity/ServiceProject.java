package com.cn.why.entity;

import lombok.Data;

@Data
//index页面的服务项目
public class ServiceProject extends Base{
    private String onBackLetter;
    private String serviceName;
    private String serviceEnglishName;
    private String href;
    private String img;
    private String type;
    private String price;
}
