package com.cn.why.exception;

import com.cn.why.common.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult error(Exception e) {
        System.out.println(".......");
        return CommonResult.failed( e.getMessage());
    }
}
