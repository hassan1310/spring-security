package com.springsecurity.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class HttpBasicAuthenticationController {

    @GetMapping("/hello")
    public String hello() {
        return "hello from basic authentication controller";
    }
}
