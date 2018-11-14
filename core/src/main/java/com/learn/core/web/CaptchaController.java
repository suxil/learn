package com.learn.core.web;

import com.learn.core.utils.CaptchaUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/4/29 0029 23:32
 */
@RestController
@RequestMapping("/web/captcha/")
public class CaptchaController {

    /**
     * 生成验证码图片
     * @return
     */
    @RequestMapping("init")
    public String initSessionCode(){
        return CaptchaUtils.initSessionCode();
    }

}
