package com.learn.oauth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/08 0025 19:59
 */
@SpringBootApplication
public class OauthClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(OauthClient1Application.class, args);
    }

    @Configuration
    @EnableOAuth2Sso
    protected static class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/", "/login**")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
        }

    }

}
