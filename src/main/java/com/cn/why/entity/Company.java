package com.cn.why.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data@EqualsAndHashCode(callSuper = false)
public class Company extends Base {
    private String logo;
    private String bottomLogo;
    private String hotLine;
    private String website;
    private String email;
    private String address;
    private String phone;
    private String qr;
}
