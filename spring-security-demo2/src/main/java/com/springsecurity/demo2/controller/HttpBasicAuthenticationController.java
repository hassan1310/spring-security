package com.springsecurity.demo2.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class HttpBasicAuthenticationController {

    @GetMapping("/authenticate")
    public String authenticate() {

        var securityContext= SecurityContextHolder.getContext().getAuthentication();
        var authorities=securityContext.getAuthorities();
        authorities.forEach(a-> System.out.println(a));

        return "authenticated";
    }
}
