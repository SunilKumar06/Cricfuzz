package com.CricStats.Cricfuzz.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

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
            }).oauth2Login(oauth -> oauth.userInfoEndpoint(userInfo -> userInfo.userService(customoAuth2userService()))).build();

        }

        @Bean
        public OAuth2UserService<OAuth2UserRequest, OAuth2User> customoAuth2userService() {
            return userRequest ->
            {
                OAuth2User oauth2User = new DefaultOAuth2UserService().loadUser(userRequest);
                String login = oauth2User.getAttribute("login");
                if (login == null) {
                    throw new IllegalArgumentException("Not Found");
                }
                List<GrantedAuthority> authorities = List.of(
                        "SunilKumar06".equalsIgnoreCase(login)
                                ? new SimpleGrantedAuthority("ROLE_ADMIN")
                                : new SimpleGrantedAuthority("ROLE_USER")
                );
                return new DefaultOAuth2User(authorities, oauth2User.getAttributes(), "login");
            };
        }

    }


