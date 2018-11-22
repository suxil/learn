package com.learn.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/25 0025 23:09
 */
@SpringBootApplication
@EnableAuthorizationServer
//@EnableResourceServer
//@EnableOAuth2Sso
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

}
