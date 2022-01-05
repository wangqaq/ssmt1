package com.cn.why.entity;

import lombok.Data;

@Data
public class Mail extends Base{
    private String email;
    private String title;
    private String detail;
    private String callBack;
    private String callBackTime;
    private String publishTime;
    private String timeType;
}
