package com.cn.why.controller;


import com.cn.why.common.CommonResult;
import com.cn.why.entity.Product;
import com.cn.why.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public CommonResult add(Product product) {
        return productService.add(product);
    }

    @PostMapping("delete")
    public CommonResult delete(Product product) {
        return productService.del(product);
    }
    @GetMapping("findAll")
    public CommonResult findAll(Product product) {
        PageHelper.startPage(product.getPage(),product.getLimit());
        return productService.findAll(product);
    }

    @GetMapping("findById")
    public CommonResult findById(Product product) {
        return productService.findById(product);
    }
    @PostMapping("enable")
    public CommonResult enable(Product product) {
        return productService.enable(product);
    }
}
