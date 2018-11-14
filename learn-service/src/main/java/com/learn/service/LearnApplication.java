package com.learn.service;

//import net.unicon.cas.client.configuration.EnableCasClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 12:08
 */
@SpringBootApplication
@ComponentScan("com.learn")
@EntityScan("com.learn.**.domain")
//@EnableCasClient
@RestController
//@EnableEncryptableProperties
public class LearnApplication {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        logger.info("home visit success");
        return "home visit success";
    }

}
