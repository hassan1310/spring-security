package com.springsecurity.demo4.config.manager;

import com.springsecurity.demo4.config.provider.ApiKeyAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var apiKeyAuthenticationProvider=new ApiKeyAuthenticationProvider(this.key);

        if(apiKeyAuthenticationProvider.supports(authentication.getClass())){
            return apiKeyAuthenticationProvider.authenticate(authentication);
        } else {
            throw new BadCredentialsException("invalid secret");
        }
    }
}
