package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.News;
import com.cn.why.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// TODO sql语句

@CrossOrigin(origins = "http://localhost", allowCredentials = "true", allowedHeaders = "*")
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService service;

    @GetMapping("add")
    public CommonResult add(News news) {
        return service.add(news);
    }

    @GetMapping("update")
    public CommonResult update(News news) {
        return service.update(news);
    }

    @GetMapping("findAll")
    public CommonResult findAll(News news) {
        return service.findAll(news);
    }

    @GetMapping("enable")
    public CommonResult enable(News news) {
        return service.enable(news);
    }

    @GetMapping("findById")
    public CommonResult findById(News news) {
        return service.findById(news);
    }

    @GetMapping("del")
    public CommonResult del(News news) {
        return service.del(news);
    }
}
