package com.learn.oauth.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/user")
    public Map<String, String> user(Principal principal) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(principal);
        Map<String, String> map = new HashMap<>();
        map.put("username", "admin");
        return map;
    }

}
