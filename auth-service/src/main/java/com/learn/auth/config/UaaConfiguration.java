package com.learn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/4 17:43
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.auth.config
 */
@Configuration
public class UaaConfiguration {

    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
