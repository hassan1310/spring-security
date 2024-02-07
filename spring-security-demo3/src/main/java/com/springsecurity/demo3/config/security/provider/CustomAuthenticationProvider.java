package com.springsecurity.demo3.config.security.provider;

import com.springsecurity.demo3.config.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${authentication.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var customAuthentication=(CustomAuthentication)authentication;
        var headerKey=customAuthentication.getKey();
        if(key.equals(headerKey)){
            return new CustomAuthentication(true,null);
        }
        else {
            throw new BadCredentialsException("invalid secret");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
