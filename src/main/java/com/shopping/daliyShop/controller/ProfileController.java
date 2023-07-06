package com.shopping.daliyShop.controller;

import com.shopping.daliyShop.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) throws Exception{
        System.out.println("ProfileController.account");
        return "account";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public String join(@RequestBody HashMap<String, Object> map) throws Exception{
        System.out.println("ProfileController.join");
        System.out.println("map : " + map);
        profileService.join(map);
        return "/loginTest";
    }

    @RequestMapping(value = "/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public String idCheck(HttpServletRequest request) throws Exception{
        System.out.println("ProfileController.idCheck");
        String usrId = request.getParameter("usrId");
        int result = profileService.idCheck(usrId);

        return Integer.toString(result);
    }

    @RequestMapping(value = "/myInfo")

    public String myInfo(Model model) throws Exception{
        System.out.println("HomeController.my-info");
        return "myInfo";
    }
    @RequestMapping(value = "/myInfoConfirm")
    public String myInfoConfirm(Model model) throws Exception{
        System.out.println("HomeController.my-info");
        return "myInfoConfirm";
    }
}
