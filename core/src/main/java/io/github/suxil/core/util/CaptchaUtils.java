package io.github.suxil.core.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/4/29 0029 23:33
 */
@Slf4j
public final class CaptchaUtils {

    private static Random random = null;

    {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            log.error("init: " + e.getMessage());
        }
    }

    private static final String CODES = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LEN = 4;
    private static final String FORMAT = "png";

    public static final String SESSION_CAPTCHA_CODE = "sessionCaptchaCode";

    private CaptchaUtils() {
    }

    /**
     * 初始化会话验证码
     * @return
     */
    public static String initSessionCode(){
        return CaptchaUtils.initSessionCode(WebUtils.getSession());
    }

    /**
     * 初始化会话验证码
     * @param session
     * @return
     */
    public static String initSessionCode(HttpSession session){
        String code = CaptchaUtils.randomCode();
        session.setAttribute(CaptchaUtils.SESSION_CAPTCHA_CODE, code);
        return CaptchaUtils.generateDataImg(code, 75, 34);
    }

    /**
     * 校验验证码是否不相等
     * @return
     */
    public static boolean notValidCode() {
        return !validCode();
    }

    /**
     * 校验验证码是否相等
     * @return
     */
    public static boolean validCode() {
        String reqVerifyCode = WebUtils.getRequestParam(SESSION_CAPTCHA_CODE);
        String sesVerifyCode = (String) WebUtils.getSessionAttribute(SESSION_CAPTCHA_CODE);
        if (StringUtils.isEmpty(reqVerifyCode) || StringUtils.isEmpty(sesVerifyCode)) return false;
        return sesVerifyCode.toLowerCase().equals(reqVerifyCode.toLowerCase());
    }

    /**
     * 根据长度生成验证码内容
     * @param len
     * @return
     */
    public static String randomCode(int len) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < len; i ++) {
            sBuilder.append(CODES.charAt(random.nextInt(CODES.length())));
        }
        return sBuilder.toString();
    }

    /**
     * 生成验证码内容
     * @return
     */
    public static String randomCode() {
        return randomCode(LEN);
    }

    /**
     * 生成验证码
     * @param code
     * @return
     */
    public static byte[] generateImg(String code) {
        return generateImg(code, 75, 30);
    }

    public static byte[] generateImg(String code, int width, int height) {
        return generateImg(code, width, height, height - 8);
    }

    /**
     * 生成验证码
     * @param code
     * @param width
     * @param height
     * @return
     */
    public static byte[] generateImg(String code, int width, int height, int size) {
        if (width == 0) {
            width = 75;
        }
        if (height == 0) {
            height = 30;
        }
        if (size == 0) {
            size = height - 8;
        }

        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = bImage.createGraphics();

        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, width, height);

        graphics2d.setColor(Color.GRAY);
        graphics2d.setFont(new Font("黑体", Font.BOLD, size));

        for (int i = 0; i < random.nextInt(7) + 7; i++) {
            graphics2d.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        for (int i = 0; i < code.length(); i++) {
            graphics2d.drawString(String.valueOf(code.charAt(i)), 5 + 16 * i, height - 6);
        }

        graphics2d.dispose();

        return imageBufToByte(bImage);
    }

    /**
     * 转换成byte数组
     * @param bImage
     * @return
     */
    public static byte[] imageBufToByte(BufferedImage bImage) {
        return imageBufToByte(bImage, FORMAT);
    }

    /**
     * 转换成byte数组
     * @param bImage
     * @param format
     * @return
     */
    public static byte[] imageBufToByte(BufferedImage bImage, String format) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (StringUtils.isEmpty(format)) {
            format = FORMAT;
        }
        try {
            ImageIO.write(bImage, format, baos);
        } catch (IOException e) {
            log.error("imageBufToByte: " + e.getMessage());
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                log.error("imageBufToByte baos close: " + e.getMessage());
            }
        }
        return baos.toByteArray();
    }

    /**
     * 通过宽高和编码转换为html可识别图片数据
     * @param code
     * @param width
     * @param height
     * @return
     */
    public static String generateDataImg(String code, int width, int height) {
        return generateDataImg(generateImg(code, width, height));
    }

    /**
     * 通过BufferedImage转换为html可识别图片数据
     * @param bImage
     * @return
     */
    public static String generateDataImg(BufferedImage bImage) {
        return generateDataImg(imageBufToByte(bImage));
    }

    /**
     * 通过BufferedImage转换为html可识别图片数据
     * @param bImage
     * @param format
     * @return
     */
    public static String generateDataImg(BufferedImage bImage, String format) {
        return generateDataImg(imageBufToByte(bImage, format));
    }

    /**
     * 通过byte[]转换为html可识别图片数据
     * @param bytes
     * @return
     */
    public static String generateDataImg(byte[] bytes) {
        /**
         * data:,文本数据
         * data:text/plain,文本数据
         * data:text/html,HTML代码
         * data:text/html;base64,base64编码的HTML代码
         * data:text/css,CSS代码
         * data:text/css;base64,base64编码的CSS代码
         * data:text/javascript,Javascript代码
         * data:text/javascript;base64,base64编码的Javascript代码
         * data:image/gif;base64,base64编码的gif图片数据
         * data:image/png;base64,base64编码的png图片数据
         * data:image/jpeg;base64,base64编码的jpeg图片数据
         * data:image/x-icon;base64,base64编码的icon图片数据
         */
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }

}
