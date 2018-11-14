package com.learn.service.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>@Title: IntelliJ IDEA.</p>
 * Description:
 * Date: 2017/3/5 0005
 * Time: 21:20
 *
 * @author Administrator
 * @version 1.0
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("thymeleaf/index");
        view.addObject("title", "每天时间行程记录系统");


        return view;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("thymeleaf/home");
        view.addObject("title", "后台系统管理");


        return view;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world.";
    }

}
