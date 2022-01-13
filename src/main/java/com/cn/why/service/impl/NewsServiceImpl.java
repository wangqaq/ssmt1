package com.cn.why.service.impl;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.News;
import com.cn.why.mapper.NewsDao;
import com.cn.why.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NewsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao dao;

    @Override
    public CommonResult findAll(News news) {
        Page page = PageHelper.startPage(news.getPage(), news.getLimit());
        List<News> newsList = dao.findAll(news);
        PageInfo info = new PageInfo(page.getResult());
        if (newsList != null) {
            return CommonResult.success(newsList, Math.toIntExact(info.getTotal()));
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult del(News news) {
        int i = dao.del(news);
        if (i == 1) {
            return CommonResult.success("");
        } else {
            return CommonResult.failed("失败");
        }
    }

    @Override
    public CommonResult add(News news) {
        int i = dao.add(news);
        if (i == 1) {
            return CommonResult.success("");
        } else {
            return CommonResult.failed("失败");
        }
    }

    @Override
    public CommonResult findById(News news) {
        news = dao.findById(news);
        if (news != null) {
            return CommonResult.success(news);
        } else {
            return CommonResult.failed();
        }
    }

    @Override
    public CommonResult update(News news) {
        int i = dao.update(news);
        if (i == 1) {
            return CommonResult.success("");
        } else {
            return CommonResult.failed("失败");
        }
    }

    @Override
    public CommonResult getCount(News news) {
        return null;
    }

    @Override
    public CommonResult enable(News news) {
        int i = dao.enable(news);
        if (i == 1) {
            return CommonResult.success("");
        } else {
            return CommonResult.failed("失败");
        }
    }
}
