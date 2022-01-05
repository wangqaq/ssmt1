package com.cn.why.service.impl;

import com.cn.why.common.CommonResult;
import com.cn.why.entity.File;
import com.cn.why.mapper.FileDao;
import com.cn.why.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FileService")
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public CommonResult findAll(File file) {
        return null;
    }

    @Override
    public CommonResult del(File file) {
        return null;
    }

    @Override
    public CommonResult add(File file) {
        int count = fileDao.add(file);
        if (count==0){
            return CommonResult.success();
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @Override
    public CommonResult findById(File file) {
        return null;
    }

    @Override
    public CommonResult update(File file) {
        return null;
    }

    @Override
    public CommonResult getCount(File file) {
        return null;
    }

    @Override
    public CommonResult enable(File file) {
        return null;
    }
}
