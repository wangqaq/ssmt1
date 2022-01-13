package com.cn.why.controller;

import com.cn.why.common.CommonResult;
import com.cn.why.common.PictureUtil;
import com.cn.why.entity.File;
import com.cn.why.entity.User;
import com.cn.why.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Slf4j
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@Controller
@RequestMapping("picture")
public class PictureController {
    @Autowired
    private FileService fileService;
//    @Autowired
//    private UserService userService;

    /**
     * 图片上传target
     *
     * @param image 文件
     * @param id    用户id
     * @return com.cn.why.common.CommonResult
     */
    @ResponseBody
    @RequestMapping(value = "/upload/type={type}/id={id}", method = RequestMethod.POST)
    public CommonResult upload(@RequestParam("file") MultipartFile image, @PathVariable int id, @PathVariable String type, HttpSession session, User user) {
        // 保存图片与本地
        String name = PictureUtil.insertPicture(type, image);
        File file = new File();
        if (name != null) {
            if (type.equals("avatar")) {
                /*
                根据id 更新用户头像
                 */
                String address = "/upload/avatar/" + name;
                file.setSrc(address);
                file.setUserId(id);
                file.setType(type);
                log.info("文件属性：" + file);
                //调用fileService，将实体类属性写入数据库
                if (fileService.add(file).getCode() == 0) {
                    //返回图片路径
                    return CommonResult.success(file);
                } else {
                    return CommonResult.failed("保存失败");
                }
            } else {
                /*
                返回图片地址
                 */
                String address = "/upload/" + type + "/" + name;
                file.setSrc(address);
                return CommonResult.success(file);
            }
        }
        return CommonResult.failed("保存失败");
    }

}
