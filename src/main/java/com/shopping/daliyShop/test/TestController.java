package com.shopping.daliyShop.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TestController {

    @GetMapping(value = "test")
    public String test() throws Exception{
        return "test";
    }
}
