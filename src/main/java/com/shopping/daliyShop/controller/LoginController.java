package com.shopping.daliyShop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    public Map<String, Object> login(@RequestBody HashMap<String, Object> map, HttpServletRequest request) throws JsonProcessingException {
        System.out.println("LoginController.login");

        Map<String, Object> resultMap = new HashMap<String, Object>();
        String hashedPassword = SHA512.encrypt(map.get("userPw").toString());
        map.put("userPw", hashedPassword);
        HashMap<String, Object> login = loginService.login(map);

        if(login != null){
            log.info("login success");
            resultMap.put("login", "success");

            /* HashMap -> Json 변환 */
            ObjectMapper mapper = new ObjectMapper();
            /* Java8의 LocalDateTime 직렬화 오류를 해결하기 위한 코드추가 */
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String userInfo = mapper.registerModule(new JavaTimeModule()).writeValueAsString(login);
            resultMap.put("userInfo", userInfo); /* 로그인한 사용자 정보 전달 */
            HttpSession session = request.getSession();
            session.setAttribute("login", "success"); /* 로그인 성공여부 저장 */
            session.setAttribute("userId", login.get("usr_id").toString()); /* 로그인한 아이디 저장 */
        } else {
            log.info("login fail");
            resultMap.put("login", "fail");
        }

        return resultMap;
    }

}
