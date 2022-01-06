package com.cn.why.service;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.User;

import java.util.List;

public interface UserService extends BaseService<User>{

    CommonResult login(User user);
    CommonResult enable(User user);
    CommonResult addText(User user);
    //删除多用户
    CommonResult delAllUser(List<String> delList);
}
