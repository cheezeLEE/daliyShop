package com.shopping.daliyShop.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping(value = "/checkout")
    public String checkout(Model model) throws Exception{
        System.out.println("HomeController.checkout");
        return "checkout";
    }

    @RequestMapping(value = "/cart")
    public String cart(Model model) throws Exception{
        System.out.println("HomeController.cart");
        return "cart";
    }

    @RequestMapping(value = "/contact")
    public String contact(Model model) throws Exception{
        System.out.println("HomeController.contact");
        return "contact";
    }

    @RequestMapping(value = "/wishlist")
    public String wishlist(Model model) throws Exception{
        System.out.println("HomeController.wishlist");
        return "wishlist";
    }

}
