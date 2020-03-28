package com.learn.service;

import com.learn.service.constance.LearnServiceConstants;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
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
@MapperScan("com.learn.service.**.mapper")
public class LearnServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(LearnServiceApplication.class).run(args);
    }

//    @Bean
//    public CircuitBreakerConfigCustomizer testCustomizer() {
//        return CircuitBreakerConfigCustomizer.of("backendA", builder -> builder.slidingWindowSize(100));
//    }

    @CircuitBreaker(name = LearnServiceConstants.BACKEND)
//    @RateLimiter(name = BACKEND)
//    @Bulkhead(name = BACKEND)
//    @Retry(name = BACKEND)
//    @TimeLimiter(name = BACKEND)
    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
