package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.Mail;
import com.cn.why.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost",allowCredentials="true", allowedHeaders="*")
@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    private MailService mailService;
    @GetMapping("findAll")
    public CommonResult findAll(Mail mail){
        return mailService.findAll(mail);
    }
    @GetMapping("enable")
    public CommonResult enable(Mail mail){
        return mailService.enable(mail);
    }
    @GetMapping("add")
    public  CommonResult add(Mail mail){
        return mailService.add(mail);
    }
    @PostMapping("update")
    public CommonResult update(Mail mail){
        return mailService.update(mail);
    }
    @PostMapping("delete")
    public CommonResult del(Mail mail){
        return mailService.del(mail);
    }
    @GetMapping("findById")
    public CommonResult findById(Mail mail){
        return mailService.findById(mail);
    }
    @PostMapping("callBack")
    public CommonResult callBack(Mail mail){
        return  mailService.callBack(mail);
    }

}
