package com.learn.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 12:08
 */
@SpringBootApplication
@ComponentScan("com.learn")
@EnableTransactionManagement
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
