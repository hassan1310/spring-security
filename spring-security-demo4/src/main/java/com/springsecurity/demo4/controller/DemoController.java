package com.springsecurity.demo4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo4")
public class DemoController {

    @GetMapping("authenticate")
    public String authenticate(){
        return "authenticated";
    }
}
