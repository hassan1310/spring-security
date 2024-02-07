package com.springsecurity.demo4.config.filter;

import com.springsecurity.demo4.config.authentication.ApiKeyAuthentication;
import com.springsecurity.demo4.config.manager.ApiKeyAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var requestKey=request.getHeader("x-api-key");
        if(requestKey==null||"null".equals(requestKey)){
            filterChain.doFilter(request,response);
        }
        var authenticationManager=new ApiKeyAuthenticationManager(key) ;
        var authentication=new ApiKeyAuthentication(requestKey,false );

        authentication= (ApiKeyAuthentication) authenticationManager.authenticate(authentication);

        if (authentication.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }else {
        throw new AuthenticationException("unauthenticated request");
    }



    }
}
