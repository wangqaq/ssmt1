package com.cn.why.service.impl;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Product;
import com.cn.why.mapper.ProductDao;
import com.cn.why.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public CommonResult enable(Product Product) {
        return CommonResult.success(productDao.enable(Product));
    }

    @Override
    public CommonResult findAll(Product Product) {
        Page page = PageHelper.startPage(Product.getPage(), Product.getLimit());
        List<Product> productList = productDao.findAll(Product);
        PageInfo info = new PageInfo<>(page.getResult());
        return CommonResult.success(productList, Math.toIntExact(info.getTotal()));
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
