package com.cn.why.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Slf4j
public class PictureUtil {
    private static final String CODES = "0123456789";
    private static final int NUM = 5;

    /**
     * 存入图片文件
     *
     * @param type    类型
     * @param picture 图片流
     * @return pictureName
     */
    public static String insertPicture(String type, MultipartFile picture) {
//        自定义路径
        String path = "D:/ssmt1web/upload/" + type + '/';
        log.info(path);
        if (picture.isEmpty()) {
            return null;
        }

        // 获取文件名
        String pictureName = picture.getOriginalFilename();
        log.info("接收到的文件名为：" + pictureName);
        // 获取文件的后缀名
        String suffixName = pictureName.substring(pictureName.lastIndexOf("."));
        log.info("获取后缀：" + suffixName);

        // 随机图片名
        pictureName = generateVerifyCode(NUM, CODES) + suffixName;
        File dest = new File(path, pictureName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            boolean i = dest.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(dest);
            log.info("上传成功后的文件路径：" + path + pictureName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
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
    public static String generateVerifyCode(int verifySize, String sources) {
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }
}
