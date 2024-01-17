package com.vti.steelwatch.configuration.jwt;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtFilterConfigure extends AbstractHttpConfigurer<JwtFilterConfigure , HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        var context = http.getSharedObject(ApplicationContext.class);
        var authenticationManager = http.getSharedObject(AuthenticationManager.class);
        var jwtEncoder = context.getBean(JwtEncoder.class);
        var jwtLoginFilter = new JwtLoginFilter(authenticationManager, jwtEncoder);
        http.addFilterBefore(jwtLoginFilter , UsernamePasswordAuthenticationFilter.class);
    }

}
