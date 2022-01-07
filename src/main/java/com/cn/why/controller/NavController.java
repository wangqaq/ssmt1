package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.Nav;
import com.cn.why.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 导航栏管理
 *
 * @return com.cn.why.common.CommonResult
 */
@CrossOrigin(origins = "http://localhost", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("nav")
public class NavController {
    @Autowired
    private NavService navService;

    @GetMapping("findAll")
    public CommonResult findAll(Nav nav) {
        return navService.findAll(nav);
    }

    @PostMapping("enable")
    public CommonResult enable(Nav nav) {
        return navService.enable(nav);
    }

    @GetMapping("findById")
    public CommonResult findById(Nav nav) {
        return navService.findById(nav);
    }

    @PostMapping("update")
    public CommonResult update(Nav nav) {
        return navService.update(nav);
    }
}
