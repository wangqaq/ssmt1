package com.cn.why.service.impl;


import com.cn.why.entity.User;
import com.cn.why.mapper.UserDao;
import com.cn.why.common.CommonResult;
import com.cn.why.service.UserService;
import com.cn.why.tool.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public CommonResult login(User user) {
        String msg;
        User i = dao.findByUsernameAndPassword(user);
        if (i == null) {
            msg = "error";
        } else {
            msg = "success";
        }
        return CommonResult.success(msg);
    }

    @Override
    public CommonResult findAll(User user) {
        List<User> users = dao.findAll(user);
        return CommonResult.success(users);
    }

    @Override
    public CommonResult del(User user) {
        int count = dao.del(user);
        return CommonResult.success(count);
    }

    @Override
    public CommonResult add(User user) {
        int count = dao.add(user);
        return CommonResult.success(count);
    }

    @Override
    public CommonResult findById(User user) {
        User model = dao.findById(user);
        return CommonResult.success(model);
    }

    @Override
    public CommonResult update(User user) {
        Date date = new Date();
        int count = dao.update(user);
        user.setUpdateTime(String.valueOf(date));
        return CommonResult.success(count);
    }

    @Override
    public CommonResult getCount(User user) {
        int count = dao.getCount(user);
        return CommonResult.success(count);
    }

    @Override
    public CommonResult enable(User User) {
        int i = dao.enable(User);
        return CommonResult.success(i);
    }

    @Override
    public CommonResult addText(User user) {
        return CommonResult.success(dao.addText(user));
    }
}
