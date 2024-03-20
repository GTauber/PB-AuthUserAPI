package com.pb.authuser.config.security;

import com.pb.authuser.config.security.managers.JWTAuthenticationManager;
import com.pb.authuser.config.security.utils.JWTTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AuthenticationManagerConfig {

    private final JWTTokenUtil jwtTokenUtil;

    private final SecurityUserService securityUserService;

    @Bean
    public JWTAuthenticationManager jwtAuthenticationManager() {
        return new JWTAuthenticationManager(jwtTokenUtil);

    }

    @Primary
    @Bean
    public UserDetailsRepositoryReactiveAuthenticationManager defaultManager() {
        var defaultManager = new UserDetailsRepositoryReactiveAuthenticationManager(securityUserService);
        defaultManager.setPasswordEncoder(new BCryptPasswordEncoder());
        return defaultManager;
    }

}
