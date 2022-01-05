package com.cn.why.service;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Nav;

public interface NavService extends BaseService<Nav>{
    CommonResult getNavModelList();
    CommonResult enable(Nav nav);
}
