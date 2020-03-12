package com.learn.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class BootAdminServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootAdminServiceApplication.class).run(args);
    }

}
