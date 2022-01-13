package com.cn.why.exception;

import com.cn.why.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult error(Exception e) {
        log.info(String.valueOf(e));
        log.info("............");
        return CommonResult.failed(e.getMessage());
    }
}
