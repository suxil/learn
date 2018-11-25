package com.learn.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/12 0012 13:22
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

//                .addFilter(new UsernamePasswordAuthenticationFilter())

                .authorizeRequests()
                .antMatchers("/login", "/oauth/*")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")

                .and()
//                .oauth2Login()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")

                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("marissa").password("wombat").roles("USER")
                .and()
                .withUser("sam").password("kangaroo").roles("USER")
                .and()
                .withUser("admin").password("123").roles("ADMIN");

    }

}