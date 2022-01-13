package com.cn.why.service.impl;

import com.cn.why.common.CommonResult;
import com.cn.why.common.Date;
import com.cn.why.entity.Mail;
import com.cn.why.mapper.MailDao;
import com.cn.why.service.MailService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private MailDao mailDao;

    @Override
    public CommonResult findAll(Mail mail) {
        Page page = PageHelper.startPage(mail.getPage(), mail.getLimit());
        List<Mail> mailList = mailDao.findAll(mail);
        for (Mail mail1 : mailList
        ) {
            if (mail1.getCallBack() == null) {
                mail1.setCallBack("未回复");
            }
        }
        PageInfo info = new PageInfo<>(page.getResult());
        if (info.getSize() != 0) {
            return CommonResult.success(mailList, Math.toIntExact(info.getTotal()));
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult del(Mail mail) {
        int i = mailDao.del(mail);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult add(Mail mail) {
        int i = mailDao.add(mail);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult findById(Mail mail) {
        Mail mail1 = mailDao.findById(mail);
        if (mail1 != null) {
            return CommonResult.success(mail1);
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult update(Mail mail) {
        int i = mailDao.update(mail);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult getCount(Mail mail) {
        return null;
    }

    @Override
    public CommonResult enable(Mail mail) {
        int i = mailDao.enable(mail);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    public CommonResult callBack(Mail mail) {
        mail.setCallBackTime(Date.getDate());
        int i = mailDao.callBack(mail);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
}
