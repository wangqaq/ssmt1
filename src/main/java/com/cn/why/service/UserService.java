package com.cn.why.service;


import com.cn.why.entity.User;
import com.cn.why.common.CommonResult;

public interface UserService extends BaseService<User>{

    CommonResult login(User user);
    CommonResult enable(User user);
    CommonResult addText(User user);
}
