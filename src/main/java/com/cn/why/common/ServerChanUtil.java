package com.cn.why.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.why.entity.ServerChan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ServerChanUtil {


    @Autowired
    private ServerChan serverChan;

    public ServerChan sendCode() {
        String url = "https://sctapi.ftqq.com/SCT58654TEI9PKAb5Fss8d6d9fk5M7yVP.send";
        String strs = "123456789";
        String randCode = PictureUtil.generateVerifyCode(5, strs);
        Map<String, String> map = new HashMap<String, String>();
        String msg = "你的验证码是：" + randCode + "，有效期十分钟，过期请重新获取";
        System.out.println(msg);
        map.put("title", "验证码");
        map.put("desp", msg);
        String result = HttpUtil.sendPost(url, map);
        //将数据封装成JSON
        JSONObject data = JSON.parseObject(result).getJSONObject("data");
        //从JSON中获取数据
        Integer pushid = data.getInteger("pushid");
        Object readkey = data.get("readkey");
        //封装到实体中
        serverChan.setPushid(String.valueOf(pushid));
        serverChan.setReadkey(String.valueOf(readkey));
        serverChan.setRandCode(randCode);
        log.info(String.valueOf(serverChan));
        return serverChan;
    }
}
