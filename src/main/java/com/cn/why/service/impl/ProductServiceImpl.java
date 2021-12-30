package com.cn.why.service.impl;


import com.cn.why.entity.Product;
import com.cn.why.mapper.ProductDao;
import com.cn.why.common.CommonResult;
import com.cn.why.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public CommonResult enable(Product Product) {
        return CommonResult.success(productDao.enable(Product));
    }

    @Override
    public CommonResult findAll(Product Product) {
        return CommonResult.success(productDao.findAll(Product), productDao.getCount(Product), "success");
    }

    @Override
    public CommonResult del(Product model) {
        return CommonResult.success(productDao.del(model));
    }

    @Override
    public CommonResult add(Product model) {
        return CommonResult.success(productDao.add(model));
    }

    @Override
    public CommonResult findById(Product model) {
        return CommonResult.success(productDao.findById(model));
    }

    @Override
    public CommonResult update(Product model) {
        return CommonResult.success(productDao.update(model));
    }

    @Override
    public CommonResult getCount(Product model) {
        return CommonResult.success(productDao.getCount(model));
    }
}
