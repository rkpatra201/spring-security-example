package com.spring.config;

import com.spring.filter.CustomAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class CustomAuthFilterConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        System.out.println("registering custom filter");
        http.csrf().disable().formLogin().loginProcessingUrl("/login").permitAll().and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated().and().addFilterBefore(customAuthFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CustomAuthFilter customAuthFilter() throws Exception {
        CustomAuthFilter authenticationFilter = new CustomAuthFilter();
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }
}

