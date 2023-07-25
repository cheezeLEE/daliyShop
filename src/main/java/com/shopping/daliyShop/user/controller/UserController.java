package com.shopping.daliyShop.user.controller;

import com.shopping.daliyShop.user.service.UserService;
import net.nurigo.java_sdk.api.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) throws Exception{
        System.out.println("ProfileController.account");
        return "account";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public int join(@RequestBody HashMap<String, Object> map) throws Exception{
        System.out.println("ProfileController.join");
            return userService.join(map);

    }

    @RequestMapping(value = "/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public String idCheck(HttpServletRequest request) throws Exception{
        System.out.println("ProfileController.idCheck");
        String usrId = request.getParameter("usrId");
        int result = userService.idCheck(usrId);

        return Integer.toString(result);
    }

    @RequestMapping(value = "/myInfo")

    public String myInfo(Model model) throws Exception{
        System.out.println("ProfileController.my-info");
        return "myInfo";
    }
    @RequestMapping(value = "/myInfoConfirm")
    public String myInfoConfirm(Model model) throws Exception{
        System.out.println("ProfileController.my-info");
        return "myInfoConfirm";
    }

    @RequestMapping(value = "sendSms")
    @ResponseBody
    public String sendSms(String to) throws Exception{
        System.out.println("ProfileController.sendSms");
        String api_key = "NCSVDKPCE0XCKFJP";
        String api_secret = "SFOXW8LUK8E8H7SLC5M4PAMN5Q8JVQK0";
        Message message = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<>();

        //6자리 난수 생성
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        System.out.println("numStr = " + numStr);
//        params.put("to", to);
//        params.put("from", "01088949752");
//        params.put("type", "SMS");
//        params.put("text", "인증번호는 [" + numStr + "] 입니다.");
//
//        message.send(params);

        return numStr;

    }
}
