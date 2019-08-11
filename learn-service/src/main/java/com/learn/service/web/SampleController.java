package com.learn.service.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is learn service.";
    }

    @GetMapping("/hello/error")
//    @HystrixCommand(fallbackMethod = "defaultStores")
    public String helloHystrix() {
        throw new RuntimeException("test");
    }

    public String defaultStores() {
        return "fail result: request error.";
    }

}
