package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.common.PictureUtil;
import com.cn.why.entity.File;
import com.cn.why.entity.User;
import com.cn.why.service.FileService;
import com.cn.why.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("picture")
public class PictureController {
    private static Logger logger = LoggerFactory.getLogger(PictureController.class);
    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

    /**
     * 图片上传target
     *
     * @param image 文件
     * @param id 用户id
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/upload/type={type}/id={id}", method = RequestMethod.POST)
    public CommonResult upload(@RequestParam("file") MultipartFile image, @PathVariable int id, @PathVariable String type, HttpSession session,User user) {
        // 保存图片与本地
        String name = PictureUtil.insertPicture(type, image);
        File file = new File();
        if (name !=null) {
            if(type.equals("avatar")){
                String address = "/upload/avatar/"+name;
                file.setSrc(address);
                file.setUserId(id);
                file.setType(type);
                fileService.add(file);
                return CommonResult.success(file);
            }else if (type.equals("user")){
                String address = "/upload/user/"+name;
                file.setSrc(address);
                return CommonResult.success(file);
            }

            // TODO 根据id更新 用户头像
            // 保存本地成功


        }

        return CommonResult.failed("保存失败");
    }

}
