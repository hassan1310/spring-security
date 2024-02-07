package com.springsecurity.demo4.config.provider;

import com.springsecurity.demo4.config.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var apiKeyAuthentication = (ApiKeyAuthentication) authentication;

        var headerKey = apiKeyAuthentication.getKey();
        if (key.equals(headerKey)) {
            return new ApiKeyAuthentication(null, true);
        } else {
            throw new InsufficientAuthenticationException("invalid secret");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (authentication.equals(ApiKeyAuthentication.class));
    }
}
