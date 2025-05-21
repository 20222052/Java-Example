package org.example.chuong4_bai4_registeraccount.Config;

import org.example.chuong4_bai4_registeraccount.Service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/account/login")
                        .userInfoEndpoint(user -> user
                                .userService(customOAuth2UserService) // 👈 Sử dụng service custom
                        )
                        .defaultSuccessUrl("/account/", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/account/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
