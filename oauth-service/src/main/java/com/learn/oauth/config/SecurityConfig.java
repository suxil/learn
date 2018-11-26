package com.learn.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/12 0012 13:22
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .antMatchers("/login", "/oauth/authorize")

                .and()
                .authorizeRequests()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select username, password, enabled from users where username = ? and enabled = 1")
        ;
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("123")).roles("USER");

    }

}