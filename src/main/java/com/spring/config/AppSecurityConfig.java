package com.spring.config;

import com.spring.provider.CustomAuthProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@Import(InMemoryUserDetailsConfig.class)
//@Import(CustomUserDetailsConfig.class)
//@Import(CustomProviderConfig.class)
@Import(CustomAuthFilterConfig.class)
public class AppSecurityConfig {
}
