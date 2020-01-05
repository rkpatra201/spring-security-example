package com.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
  //  @PreAuthorize("hasAnyRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> welcomeUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userInfo = authentication.getName()+":"+ authentication.getPrincipal() + ":"+authentication.getAuthorities();
        return ResponseEntity.ok("Welcome: "+userInfo);
    }
}
