package com.cn.why.mapper;

import com.cn.why.entity.Mail;

public interface MailDao extends BaseDao<Mail> {
    int callBack(Mail mail);
}
