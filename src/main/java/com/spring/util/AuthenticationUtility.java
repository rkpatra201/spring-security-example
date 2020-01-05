package com.spring.util;

import com.spring.model.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationUtility {
    private static GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();


    public static Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AppUser appUser = new AppUser("john","12345","ADMIN,USER");
        UserDetails userDetails = User.withDefaultPasswordEncoder(). // builder design pattern given by spring
                username(appUser.getUserName()).
                password(appUser.getPassword()).
                roles(appUser.getRoles().split(",")).
                build();


        // validate password here.
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken("write your principal object", authentication.getCredentials(), authoritiesMapper.mapAuthorities(userDetails.getAuthorities()));
        result.setDetails(authentication.getDetails());
        return result;
    }

}
