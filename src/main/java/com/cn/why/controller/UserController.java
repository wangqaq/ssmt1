package com.cn.why.controller;


import com.cn.why.pojo.User;
import com.cn.why.result.ResultModel;
import com.cn.why.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    public UserController(UserService service) {
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
        ResultModel resultModel;
        resultModel = userService.findAll(user);
        return resultModel;
    }


    @RequestMapping("enable")
    public ResultModel enable(User user) {
        ResultModel resultModel = userService.enable(user);
        return resultModel;
    }
    @RequestMapping("finById")
    public ResultModel findById(User user){
        ResultModel resultModel = userService.findById(user);
        return resultModel;
    }

}
