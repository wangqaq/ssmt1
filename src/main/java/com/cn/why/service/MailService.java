package com.cn.why.service;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.Mail;

public interface MailService extends BaseService<Mail>{
    CommonResult callBack(Mail mail);
}
