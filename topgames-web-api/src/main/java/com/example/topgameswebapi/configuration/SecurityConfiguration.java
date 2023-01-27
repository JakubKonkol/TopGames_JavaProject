package com.example.topgameswebapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfiguration{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/api/**", "/logs/**", "/logs", "/api", "/oauth2/**", "/oauth2")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .cors().disable()
                .csrf().disable();

        http
                .oauth2Login();
        return http.build();
    }

}



