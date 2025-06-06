package org.example.chuong4_bai3.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/account/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
