package com.cn.why.controller;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Product;
import com.cn.why.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public CommonResult add(Product product) {
        CommonResult commonResult = productService.add(product);
        return commonResult;
    }

    @PostMapping("delete")
    public CommonResult delete(Product product) {
        CommonResult commonResult = productService.del(product);
        return commonResult;
    }
    @GetMapping("findAll")
    public CommonResult findAll(Product product) {
        PageHelper.startPage(product.getPage(),product.getLimit());
        CommonResult commonResult = productService.findAll(product);
        return commonResult;
    }

    @GetMapping("findById")
    public CommonResult findById(Product product) {
        CommonResult commonResult = productService.findById(product);
        return commonResult;
    }
    @PostMapping("enable")
    public CommonResult enable(Product product) {
        CommonResult commonResult = productService.enable(product);
        return commonResult;
    }
}
