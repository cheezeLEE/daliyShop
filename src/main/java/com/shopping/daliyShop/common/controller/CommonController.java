package com.shopping.daliyShop.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
    @RequestMapping(value = "/error404")
    public String error404(Model model) throws Exception{
        System.out.println("HomeController.error404");
        return "404";
    }

    @RequestMapping(value = "/loginTest")
    public String loginTest(Model model) throws Exception{
        System.out.println("HomeController.loginTest");
        return "loginTest";
    }
}
