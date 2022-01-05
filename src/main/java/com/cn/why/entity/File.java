package com.cn.why.entity;

import lombok.Data;

@Data
public class File extends Base {
    private String src;
    private int userId;
    private String type;
}
