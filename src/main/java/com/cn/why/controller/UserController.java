package com.cn.why.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.why.common.CommonResult;
import com.cn.why.common.HttpUtil;
import com.cn.why.common.PictureUtil;
import com.cn.why.entity.ServerChan;
import com.cn.why.entity.User;
import com.cn.why.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户管理
 *
 * @return com.cn.why.common.CommonResult
 */

@CrossOrigin(origins = "http://localhost", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    private Jedis jedis = new Jedis();

    // TODO   忘记密码
    @PostMapping("rePassword")
    public CommonResult rePassword(User user) {
        String randcode = user.getCode();
        /*
        发送验证码
         */
        String url = "https://sctapi.ftqq.com/SCT58654TEI9PKAb5Fss8d6d9fk5M7yVP.send";
        String strs = "123456789";
        String code = PictureUtil.generateVerifyCode(5, strs);
        Map<String, String> map = new HashMap<String, String>();
        String msg = "你的验证码是：" + code + "，有效期十分钟，过期请重新获取";
        System.out.println(msg);
        map.put("title", "中国铁塔");
        map.put("desp", msg);
        String result = HttpUtil.sendPost(url, map);
        System.out.println(result);
        //将数据封装成JSON
        JSONObject data = JSON.parseObject(result).getJSONObject("data");
        //从JSON中获取数据
        Integer pushid = data.getInteger("pushid");
        Object readkey = data.get("readkey");
        //封装到实体中
        ServerChan serverChan = new ServerChan();
        serverChan.setPushid(String.valueOf(pushid));
        serverChan.setReadkey(String.valueOf(readkey));
        serverChan.setCode(code);
        int i = 10/0;
        return CommonResult.success();
    }

    @PostMapping("login")
    public CommonResult login(@RequestBody User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        String checkCode = (String) session.getAttribute("verifyCodeValue");
        CommonResult commonResult = userService.login(user);
        Jedis jedis = new Jedis("localhost");
        jedis.set("commonResult", String.valueOf(commonResult));
        //如果登陆成功，则将loginName写入到session中
        if (commonResult.getData().equals("登陆成功")) {
            session.setAttribute("loginName", user.getUsername());
            //设置session过期时间，单位s
            session.setMaxInactiveInterval(60 * 10);
            Cookie[] cookie = request.getCookies();
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getValue() != null) {
                    logger.info((String) session.getAttribute("loginName"));
                    logger.info("Cookie:" + cookie[i].getName() + "=" + cookie[i].getValue() + ",i=" + i);
                    jedis.set(cookie[i].getName(), cookie[i].getValue());
                    jedis.expire(cookie[i].getName(), 600);
                }
            }
            commonResult.setMessage(user.getUsername());
        }

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
    public CommonResult findById(User user) {
        return userService.findById(user);
    }

    //删除多用户
    @PostMapping("delAllUser")
    public CommonResult delAllUser(String ids) {
        String[] strs = ids.split(",");
        List<String> delList = new ArrayList<>(Arrays.asList(strs));
        return userService.delAllUser(delList);
    }

    @GetMapping("delete")
    public CommonResult delete(User user) {
        int count;
        CommonResult commonResult = userService.del(user);
        count = userService.getCount(user).getCount();
        jedis.set("count", String.valueOf(count));
        jedis.expire("count", 600);
        commonResult.setCount(count);
        return commonResult;
    }

    @GetMapping("add")
    public CommonResult add(User user) {
//        int count;
//        CommonResult commonResult = userService.add(user);
//        count = userService.getCount(user).getCount();
//        jedis.set("count",String.valueOf(count));
//        jedis.expire("count",600);
//        commonResult.setCount(count);
        return userService.add(user);
    }

    @PostMapping("update")
    public CommonResult edit(User user) {
        return userService.update(user);
    }
}
