package com.learn.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 12:08
 */
@SpringBootApplication
@ComponentScan("com.learn")
@EnableDiscoveryClient
@EnableFeignClients("com.learn")
@RibbonClients
@EnableTransactionManagement
//@EnableCircuitBreaker
@MapperScan("com.learn.auth.**.mapper")
public class AuthServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthServiceApplication.class).run(args);
    }

}
