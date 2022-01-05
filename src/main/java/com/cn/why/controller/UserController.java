package com.cn.why.controller;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.User;
import com.cn.why.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@CrossOrigin(origins = "http://localhost")
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
        Jedis jedis  = new Jedis("localhost");
        jedis.set("commonResult", String.valueOf(commonResult));
        if (commonResult.getData().equals("success")){
            request.getSession().setAttribute("loginName",user.getUsername());
            session.setAttribute("loginName",user.getUsername());
            //设置session过期时间，单位s
            session.setMaxInactiveInterval(60*10);
            Cookie[] cookie= request.getCookies();
            for (int i=0;i<cookie.length;i++){
                if (cookie[i].getValue()!=null){
                    System.out.println(session.getAttribute("loginName"));
                    System.out.println("Cookie:"+cookie[i].getName()+"="+cookie[i].getValue()+"i="+i);
                    jedis.set(cookie[i].getName(),cookie[i].getValue());
                    jedis.expire(cookie[i].getName(),600);
                }
            }
            commonResult.setMessage(user.getUsername());
        }

        //验证码校验
//        if (!checkCode.equals("")) {
//        //equalsIgnoreCase忽略大小写
//            if (!checkCode.equalsIgnoreCase(user.getCode())) {
//                commonResult.setData("codeErr");
//            }
//        }else{
//            commonResult.setMsg("codeNull");
//        }
        return commonResult;
    }


    @GetMapping("findAll")
    public CommonResult FindAll(User user) {
        return userService.findAll(user);
    }


    @GetMapping("enable")
    public CommonResult enable(User user) {
        return userService.enable(user);
    }
    @GetMapping("findById")
    public CommonResult findById(User user){
        return userService.findById(user);
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
    @PostMapping("update")
    public CommonResult edit(User user){
        return userService.update(user);
    }
}
