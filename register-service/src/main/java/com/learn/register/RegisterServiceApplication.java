package com.learn.register;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterServiceApplication.class).run(args);
    }

}
