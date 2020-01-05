package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;


public class InMemoryUserDetailsConfig extends WebSecurityConfigurerAdapter
{

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       // return super.userDetailsService();
        List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
        UserDetails userDetails = User.withDefaultPasswordEncoder(). // builder design pattern given by spring
                username("john").
                password("12345").
                roles("ADMIN","USER").
                build();
        userDetailsList.add(userDetails);
        return new InMemoryUserDetailsManager(userDetailsList);
    }
}
