package com.shopping.daliyShop.login.controller;

import com.shopping.daliyShop.user.model.UserVO;
import com.shopping.daliyShop.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /* Custom Login */
    @GetMapping("/login")
    public String loginForm() {
        System.out.println("LoginController.loginForm");
        return "loginTest";
    }

//    @PostMapping("/loginProc")
//    @ResponseBody
//    public Map<String, Object> login(@RequestBody HashMap<String, Object> map, HttpServletRequest request) throws JsonProcessingException {
//        System.out.println("LoginController.login");
//
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        String hashedPassword = SHA512.encrypt(map.get("userPw").toString());
//        map.put("userPw", hashedPassword);
//        HashMap<String, Object> login = loginService.login(map);
//
//        if(login != null){
//            log.info("login success");
//            resultMap.put("login", "success");
//
//            /* HashMap -> Json 변환 */
//            ObjectMapper mapper = new ObjectMapper();
//            /* Java8의 LocalDateTime 직렬화 오류를 해결하기 위한 코드추가 */
//            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//            String userInfo = mapper.registerModule(new JavaTimeModule()).writeValueAsString(login);
//            resultMap.put("userInfo", userInfo); /* 로그인한 사용자 정보 전달 */
//            HttpSession session = request.getSession();
//            session.setAttribute("login", "success"); /* 로그인 성공여부 저장 */
//            session.setAttribute("userId", login.get("usr_id").toString()); /* 로그인한 아이디 저장 */
//        } else {
//            log.info("login fail");
//            resultMap.put("login", "fail");
//        }
//
//        return resultMap;
//    }

//    @PostMapping("/logout")
//    @ResponseBody
//    public String logout(HttpServletRequest request) {
//        System.out.println("LoginController.logout");
//        HttpSession session = request.getSession();
//        session.invalidate();
//
//        return "success";
//    }

    @GetMapping("/join2")
    public String join(Model model) {

        return "join";
    }

    @PostMapping("/joinTest")
    public String joinPost(Model model, UserVO userVO) {
        log.info("join controller");

        String encode = passwordEncoder.encode(userVO.getUsrPw());
        userVO.setUsrPw(encode);

        loginService.join(userVO);

        model.addAttribute("user", userVO);
        return "index";
    }

    @GetMapping("/searchId")
    public String searchIdForm(HttpServletRequest request, Model model) {
        System.out.println("LoginController.searchIdForm");

        return "/searchId";
    }

    @PostMapping("/searchId")
    @ResponseBody
    public String searchId(@RequestBody HashMap<String, Object> map) {
        System.out.println("LoginController.searchId");
        String searchId = loginService.searchId(map);

        return searchId;
    }

    @PostMapping("/resultId")
    public String resultId(@RequestParam HashMap<String, Object> map, Model model){
        System.out.println("LoginController.resultId");
        model.addAttribute("resultId", map.get("resultId"));
        return "/resultId";
    }

    @GetMapping("/searchPw")
    public String searchPwForm(HttpServletRequest request, Model model) {
        System.out.println("LoginController.searchPwForm");

        return "/searchPw";
    }

    @PostMapping("/searchPw")
    @ResponseBody
    public String searchPw(@RequestBody HashMap<String, Object> map) {
        System.out.println("LoginController.searchPw");

        return "비밀번호";
    }
}
