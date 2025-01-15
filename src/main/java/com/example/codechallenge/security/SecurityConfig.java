package com.example.codechallenge.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    //ESTO FUE COMENTADO PORQUE BLOQUEABA LAS PETICIONES AL SWAGGER

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api-docs/**", "/swagger-ui/**",
                                "/swagger-ui.html", "/v3/api-docs/**", "/api/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }*/
}
