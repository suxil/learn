package com.learn.oauth.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/protected")
    public String protected1(HttpServletRequest request, Model model) {
        return "protected";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Model model) {
        return "protected";
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

}