package com.shopping.daliyShop.controller;

import com.shopping.daliyShop.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("testModel", new TestModel());
        return "test/test";
    }

    @PostMapping("/test/insert")
    public String testInsert(@ModelAttribute TestModel testModel){



        return "test/testList";
    }

    @GetMapping("/thymeleafTest")
    public String thymeleafTest(Model model){
        model.addAttribute("thText", "변수가 존재할 경우 태그내부값 변수값으로 대체");
        model.addAttribute("thUtext", "<b>변수에서 받은 값에 html 태그가 있으면 태그값을 반영해 표시</b>");
        model.addAttribute("thValue", "엘리먼트들의 value값을 지정할 수 있음");
        model.addAttribute("thWith", "변수값을 지정해서 사용 가능(c:set)");
        int[] array = {1,2,3,4};
        model.addAttribute("thSwitch", array);
        String[] array2 = {"여자", "남자", "남자", "여자"};
        model.addAttribute("thIf", array2);

        model.addAttribute("testModel", new TestModel());

        return "test/thymeleafTest";
    }

    @PostMapping("/test/join")
    public String testJoin(@ModelAttribute TestModel testModel, Model model){
        log.info("id : {}, pw : {}, name : {}", testModel.getUsrId(), testModel.getUsrPw(), testModel.getUsrName());
        model.addAttribute("testModel", testModel);
        return "test/testList";
    }
}