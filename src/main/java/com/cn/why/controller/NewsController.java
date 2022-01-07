package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.News;
import com.cn.why.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


// TODO 请求路径和sql语句

@CrossOrigin(origins = "http://localhost", allowCredentials = "true", allowedHeaders = "*")
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService service;

    public CommonResult add(News news) {
        return service.add(news);
    }

    public CommonResult update(News news) {
        return service.update(news);
    }

    public CommonResult findAll(News news) {
        return service.findAll(news);
    }

    public CommonResult enable(News news) {
        return service.enable(news);
    }

    public CommonResult findById(News news) {
        return service.findById(news);
    }

    public CommonResult del(News news) {
        return service.del(news);
    }
}
