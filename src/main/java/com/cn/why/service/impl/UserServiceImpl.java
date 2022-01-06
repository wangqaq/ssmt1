package com.cn.why.service.impl;


import com.cn.why.common.CommonResult;
import com.cn.why.common.Date;
import com.cn.why.entity.User;
import com.cn.why.mapper.UserDao;
import com.cn.why.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public CommonResult login(User user) {
        User i = dao.findByUsernameAndPassword(user);
        if (i == null) {
            return CommonResult.failed("登陆失败");
        } else {
            return CommonResult.success("登陆成功");
        }
    }

    @Override
    public CommonResult findAll(User user) {
        if (user.getStart()!=null){
            if (user.getStart().equals("")){
                user.setStart(null);
            }
        }
        if (user.getEnd()!=null){
            if (user.getEnd().equals("")){
                user.setEnd(null);
            }
        }
        Page page = PageHelper.startPage(user.getPage(),user.getLimit());
        List<User> userList= dao.findAll(user);
        PageInfo info = new PageInfo<>(page.getResult());
        return CommonResult.success (userList, Math.toIntExact(info.getTotal()));
    }

    @Override
    public CommonResult del(User user) {
        int i = dao.del(user);
        return CommonResult.success(i);
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
        user.setUpdateTime(String.valueOf(date));
        int count = dao.update(user);
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

    @Override
    public CommonResult delAllUser(List<String> delList) {
        int i=  dao.delAllUser(delList);
        return CommonResult.success(i);
    }
}
