package com.cn.why.service;


import com.cn.why.result.ResultModel;

public interface BaseService<T> {
    ResultModel findAll(T t);

    ResultModel del(T t);

    ResultModel add(T t);

    ResultModel findById(T t);

    ResultModel update(T t);

    ResultModel getCount(T t);
    ResultModel enable(T t);
}
