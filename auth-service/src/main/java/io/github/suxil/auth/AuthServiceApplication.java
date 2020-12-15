package io.github.suxil.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 12:08
 */
@SpringBootApplication
@ComponentScan(value = {"io.github.suxil"})
@EnableDiscoveryClient
@EnableFeignClients(value = {"io.github.suxil"})
@RibbonClients
@EnableTransactionManagement
@MapperScan(value = {"io.github.suxil.auth.**.converter", "io.github.suxil.auth.**.repository"})
public class AuthServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthServiceApplication.class).run(args);
    }

}
