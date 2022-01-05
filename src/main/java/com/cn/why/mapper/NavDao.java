package com.cn.why.mapper;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Nav;

public interface NavDao extends BaseDao<Nav>{
    CommonResult getNavModelList();
    int enable(Nav nav);
}
