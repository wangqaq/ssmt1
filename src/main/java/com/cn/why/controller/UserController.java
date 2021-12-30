package com.cn.why.controller;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.User;
import com.cn.why.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    private Jedis jedis = new Jedis();

    @PostMapping("login")
    public CommonResult login(@RequestBody User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        String checkCode = (String) session.getAttribute("verifyCodeValue");
        CommonResult commonResult = userService.login(user);
//        Jedis jedis  = new Jedis("localhost");
//        jedis.set("commonResult", String.valueOf(commonResult));
        if (commonResult.getMessage().equals("success")){
            session.setAttribute("loginName",user.getUsername());
        }
        //验证码校验
//        if (!checkCode.equals("")) {
//            if (!checkCode.equals(user.getCode())) {
//                commonResult.setData("codeErr");
//            }
//        }else{
//            commonResult.setMsg("codeNull");
//        }
        return commonResult;
    }


    @GetMapping("findAll")
    public CommonResult FindAll(User user) {
        CommonResult commonResult;
        Page page= PageHelper.startPage(user.getPage(),user.getLimit());
        commonResult = userService.findAll(user);
        PageInfo info = new PageInfo<>(page.getResult());
        commonResult.setCount(info.getSize());
        return commonResult;
    }


    @GetMapping("enable")
    public CommonResult enable(User user) {
        CommonResult commonResult = userService.enable(user);
        return commonResult;
    }
    @GetMapping("findById")
    public CommonResult findById(User user){
        CommonResult commonResult = userService.findById(user);
        return commonResult;
    }
    @GetMapping("delete")
    public CommonResult delete(User user){
        int count;
        CommonResult commonResult = userService.del(user);
        count = userService.getCount(user).getCount();
        jedis.set("count",String.valueOf(count));
        jedis.expire("count",600);
        commonResult.setCount(count);
        return  commonResult;
    }
    @GetMapping("add")
    public CommonResult add(User user){
        int count;
        CommonResult commonResult = userService.add(user);
        count = userService.getCount(user).getCount();
        jedis.set("count",String.valueOf(count));
        jedis.expire("count",600);
        commonResult.setCount(count);
        return  commonResult;
    }
    @GetMapping("update")
    public CommonResult edit(User user){
        CommonResult commonResult = userService.update(user);
        return commonResult;
    }
}
