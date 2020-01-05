package com.spring.service;

import com.spring.model.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // appUser can be from you data base too
        AppUser appUser = new AppUser("john","12345","ADMIN,USER");
        UserDetails userDetails = User.withDefaultPasswordEncoder(). // builder design pattern given by spring
                username(appUser.getUserName()).
                password(appUser.getPassword()).
                roles(appUser.getRoles().split(",")).
                build();
        return userDetails;
    }
}
