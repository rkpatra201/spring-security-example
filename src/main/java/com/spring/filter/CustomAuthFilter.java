package com.spring.filter;

import com.spring.util.AuthenticationUtility;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Authentication auth=null;
        System.out.println("executing custom filter");
        String userName=super.obtainUsername(request);
        String password=super.obtainPassword(request);
        auth=new UsernamePasswordAuthenticationToken(userName,password);
        return AuthenticationUtility.authenticate(auth);
    }
}
