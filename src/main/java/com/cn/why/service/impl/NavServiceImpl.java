package com.cn.why.service.impl;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Nav;
import com.github.pagehelper.*;
import com.cn.why.mapper.NavDao;
import com.cn.why.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NavService")
public class NavServiceImpl implements NavService {
    @Autowired
    private NavDao navDao;

    @Override
    public CommonResult getNavModelList() {
        return CommonResult.success(navDao.getNavModelList());
    }

    @Override
    public CommonResult enable (Nav nav) {
        int i = navDao.enable (nav);
        return CommonResult.success (i);
    }

    @Override
    public CommonResult findAll (Nav nav) {
        Page page = PageHelper.startPage(nav.getPage(),nav.getLimit());
        List<Nav> navList= navDao.findAll(nav);
        PageInfo info = new PageInfo<>(page.getResult());
        return CommonResult.success (navList,info.getSize());
    }
    @Override
    public CommonResult del (Nav nav) {
        int count = navDao.del (nav);
        if (count == 1){
            return CommonResult.success ();
        }else{
            return CommonResult.failed("删除失败");
        }
    }

    @Override
    public CommonResult add (Nav nav) {
        int count = navDao.add (nav);
        if (count == 1){
            return CommonResult.success ();
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @Override
    public CommonResult findById (Nav nav) {
        nav = navDao.findById (nav);
        if (nav!=null){
            return CommonResult.success (nav);
        }else {
            return CommonResult.failed("查无此人");
        }
    }

    @Override
    public CommonResult update (Nav nav) {
        int count = navDao.update (nav);
        if (count == 1){
            return CommonResult.success ();
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @Override
    public CommonResult getCount (Nav nav) {
        return null;
    }
}
