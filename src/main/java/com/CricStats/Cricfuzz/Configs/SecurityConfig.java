package com.CricStats.Cricfuzz.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests(auth -> {
                auth.requestMatchers(HttpMethod.GET,"/player/**").hasAnyRole("USER","ADMIN");
                auth.requestMatchers(HttpMethod.POST,"/player/**").hasAnyRole("ADMIN");
                auth.requestMatchers(HttpMethod.PUT,"/player/**").hasAnyRole("ADMIN");
                auth.requestMatchers(HttpMethod.DELETE,"/player/**").hasAnyRole("ADMIN");
                auth.anyRequest().authenticated();
            }).formLogin(Customizer.withDefaults()).oauth2Client(Customizer.withDefaults()).build();

        }
    }


