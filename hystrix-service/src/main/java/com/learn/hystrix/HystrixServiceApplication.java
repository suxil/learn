package com.learn.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.learn")
@EnableDiscoveryClient
@EnableFeignClients("com.learn")
@RibbonClients
@EnableTransactionManagement
@EnableHystrixDashboard
public class HystrixServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixServiceApplication.class).run(args);
    }

}
