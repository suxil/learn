package com.learn.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:20
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
