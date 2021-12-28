package com.cn.why.service;


import com.cn.why.pojo.User;
import com.cn.why.result.ResultModel;

public interface UserService extends BaseService<User>{

    ResultModel login(User user);
    ResultModel enable(User user);
    ResultModel addText(User user);
}
