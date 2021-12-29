package com.cn.why.controller;


import com.cn.why.entity.User;
import com.cn.why.result.ResultModel;
import com.cn.why.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.*;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;
    private Jedis jedis = new Jedis();

    private UserController(UserService service) {
        this.userService = service;
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultModel login(@RequestBody User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        String checkCode = (String) session.getAttribute("verifyCodeValue");
        ResultModel resultModel = userService.login(user);
//        Jedis jedis  = new Jedis("localhost");
//        jedis.set("resultModel", String.valueOf(resultModel));
        if (resultModel.getMsg().equals("success")){
            session.setAttribute("loginName",user.getUsername());
        }
        //验证码校验
//        if (!checkCode.equals("")) {
//            if (!checkCode.equals(user.getCode())) {
//                resultModel.setData("codeErr");
//            }
//        }else{
//            resultModel.setMsg("codeNull");
//        }
        return resultModel;
    }


    @RequestMapping("findAll")
    public ResultModel FindAll(User user) {
        int count;
        ResultModel resultModel;
        //判断jedis中的count是否存在 减少sql查询
        if (jedis.get("count")==null){
            count = userService.getCount(user).getCount();
            jedis.set("count",String.valueOf(count),"XX","EX",600);
        }else {
            count=Integer.valueOf(jedis.get("count"));
        }
        //分页
        PageHelper.startPage(user.getPage(),user.getLimit());
        resultModel = userService.findAll(user);
        resultModel.setCount(count);
        return resultModel;
    }


    @RequestMapping("enable")
    public ResultModel enable(User user) {
        ResultModel resultModel = userService.enable(user);
        return resultModel;
    }
    @RequestMapping("findById")
    public ResultModel findById(User user){
        ResultModel resultModel = userService.findById(user);
        return resultModel;
    }
    @RequestMapping("delete")
    public ResultModel delete(User user){
        ResultModel resultModel = userService.del(user);
        return  resultModel;
    }
    @RequestMapping("add")
    public ResultModel add(User user){
        int count;
        count = userService.getCount(user).getCount();
        jedis.set("count",String.valueOf(count));
        jedis.expire("count",600);
        ResultModel resultModel = userService.add(user);
        return  resultModel;
    }
    public ResultModel edit(User user){
        ResultModel resultModel = userService.update(user);
        return resultModel;
    }
}
