package com.cn.why.entity;

import lombok.Data;

@Data
public class ServerChan extends Base{
    private String title;
    private String desp;
    private String pushid;
    private String readkey;
    private String data;
    private String randCode;
}
