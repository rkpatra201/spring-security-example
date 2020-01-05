package com.spring.config;

import com.spring.provider.CustomAuthProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class CustomProviderConfig extends WebSecurityConfigurerAdapter {

    public AuthenticationProvider  authenticationProvider()
    {
        CustomAuthProvider customAuthProvider = new CustomAuthProvider();
        return  customAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  super.configure(auth);
        System.out.println("**loading custom auth provider**");
        auth.authenticationProvider(authenticationProvider());
    }
}
