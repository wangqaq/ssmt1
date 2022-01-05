package com.cn.why.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PictureUtil {

    private static final Logger logger = LoggerFactory.getLogger(PictureUtil.class);

    private static final String CODES = "0123456789";
    private static final int NUM = 5;

    /**
     * 存入图片文件于本地
     *
     * @param type  类型
     * @param picture 图片流
     * @return pictureName
     */
    public static String insertPicture(String type, MultipartFile picture) {
        // 获取路径
        String path ="D:/ssmt1web/upload/" + type + '/';
        logger.info(path);
        if (picture.isEmpty()) {
            return null;
        }

        // 获取文件名
        String pictureName = picture.getOriginalFilename();
        logger.info("接收到的文件名为：" + pictureName);
        // 获取文件的后缀名
        String suffixName = pictureName.substring(pictureName.lastIndexOf("."));
        logger.info("获取后缀：" + suffixName);

        // 随机图片名
        pictureName = generateVerifyCode(NUM,CODES) + suffixName;
        File dest = new File(path, pictureName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(dest);
            logger.info("上传成功后的文件路径：" + path + pictureName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return pictureName;
    }

    /**
     * 使用指定源生成验证码
     *
     * @param verifySize 验证码长度
     * @param sources    验证码字符源
     * @return String
     */
    private static String generateVerifyCode(int verifySize, String sources) {
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }
}
