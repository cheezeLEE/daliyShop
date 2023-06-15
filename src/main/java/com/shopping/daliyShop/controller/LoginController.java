package com.shopping.daliyShop.controller;

import com.shopping.daliyShop.config.SHA512;
import com.shopping.daliyShop.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm() {
        System.out.println("LoginController.loginForm");
        return "loginTest";
    }

    @PostMapping("/loginProc")
    @ResponseBody
    public Map<String, Object> login(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
        System.out.println("LoginController.login");

        Map<String, Object> resultMap = new HashMap<String, Object>();

        HashMap<String, Object> login = loginService.login(map);

        String hashedPassword = SHA512.encrypt(map.get("userPw").toString());
        boolean isPasswordMatch = hashedPassword.equals(login.get("usr_pw").toString());

        if(isPasswordMatch){
            log.info("login success");
            resultMap.put("login", "success");
            HttpSession session = request.getSession();
            session.setAttribute("loginSession", "success");
        } else {
            log.info("login fail");
            resultMap.put("login", "fail");
        }

        return resultMap;
    }

}
