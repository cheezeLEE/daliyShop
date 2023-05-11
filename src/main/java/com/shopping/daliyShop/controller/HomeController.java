package com.shopping.daliyShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    /* TODO /를 추가로 3번 더 호출하는 이유 */
    @RequestMapping(value = "/index")
    public String home(HttpServletRequest request, Model model, @RequestParam(value = "login", required = false) String login) throws Exception{
        System.out.println("HomeController.home");
        /* Security에서 권한이 없으면 login=false를 넘겨줌 */
        model.addAttribute("login", login);
        return "index";
    }

    @RequestMapping(value = "/error404")
    public String error404(Model model) throws Exception{
        System.out.println("HomeController.error404");
        return "404";
    }

    @RequestMapping(value = "/account")
    public String account(Model model) throws Exception{
        System.out.println("HomeController.account");
        return "account";
    }

    @RequestMapping(value = "/blog-archive")
    public String blogArchive(Model model) throws Exception {
        System.out.println("HomeController.blogArchive");
        return "blog-archive";
    }

    @RequestMapping(value = "/blog-archive-2")
    public String blogArchive2(Model model) throws Exception{
        System.out.println("HomeController.blogArchive2");
        return "blog-archive-2";
    }

    @RequestMapping(value = "/blog-single")
    public String blogSingle(Model model) throws Exception {
        System.out.println("HomeController.blogSingle");
        return "blog-single";
    }

    @RequestMapping(value = "/cart")
    public String cart(Model model) throws Exception{
        System.out.println("HomeController.cart");
        return "cart";
    }

    @RequestMapping(value = "/checkout")
    public String checkout(Model model) throws Exception{
        System.out.println("HomeController.checkout");
        return "checkout";
    }

    @RequestMapping(value = "/contact")
    public String contact(Model model) throws Exception{
        System.out.println("HomeController.contact");
        return "contact";
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

    @RequestMapping(value = "/wishlist")
    public String wishlist(Model model) throws Exception{
        System.out.println("HomeController.wishlist");
        return "wishlist";
    }

    @RequestMapping(value = "/loginTest")
    public String loginTest(Model model) throws Exception{
        System.out.println("HomeController.loginTest");
        return "loginTest";
    }

    @RequestMapping(value = "/my-info")
    public String myInfo(Model model) throws Exception{
        System.out.println("HomeController.my-info");
        return "my-info";
    }
}
