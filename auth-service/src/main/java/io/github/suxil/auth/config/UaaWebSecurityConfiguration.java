package io.github.suxil.auth.config;

import io.github.suxil.auth.security.UaaAccessDeniedHandler;
import io.github.suxil.auth.security.UaaAuthenticationEntryPoint;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class UaaWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")

                .antMatchers("/webjars/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/api-docs")
                .antMatchers("/swagger-resources/**")

                .antMatchers("/druid/**")
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .accessDeniedHandler(new UaaAccessDeniedHandler())
                .authenticationEntryPoint(new UaaAuthenticationEntryPoint())
                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .httpBasic()
                .and()
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v0/auth/login").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated();
    }

}
