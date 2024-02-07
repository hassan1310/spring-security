package com.springsecurity.demo3.controller;

import com.springsecurity.demo3.config.security.authentication.CustomAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filter-chain-authentication")
public class FilterChainAuthenticationController {

    @GetMapping("authenticate")
    public String authenticate(){

        /*var authentication=(CustomAuthentication)SecurityContextHolder.getContext().getAuthentication();
        System.out.println(" *********** authentication key is : "+authentication.getKey());*/

        return "authenticated";
    }
}
