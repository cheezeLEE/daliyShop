package com.shopping.daliyShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping(value = "/account")
    public String account(Model model) throws Exception{
        System.out.println("HomeController.account");
        return "account";
    }
}
