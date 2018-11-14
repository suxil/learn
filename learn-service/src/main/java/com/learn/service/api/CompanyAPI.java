package com.learn.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/6/26 0026 22:59
 */
@RestController
public class CompanyAPI {

    @RequestMapping("/api/v1/company/test")
    public String test() {
        return "";
    }

}
