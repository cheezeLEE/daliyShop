package com.shopping.daliyShop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    @RequestMapping(value = "/index")
    public String home(HttpServletRequest request, Model model, @RequestParam(value = "login", required = false) String login) throws Exception{
        System.out.println("HomeController.home");
        /* Security에서 권한이 없으면 login=false를 넘겨줌 */
        model.addAttribute("login", login);
        return "index";
    }

    @RequestMapping(value = "/product")
    public String product(Model model) throws Exception{
        System.out.println("HomeController.product");
        return "product";
    }

    @RequestMapping(value = "/product-detail")
    public String productDetail(Model model) throws Exception{
        System.out.println("HomeController.productDetail");
        return "product-detail";
    }
}
