package com.mysite.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        // 권한은 순서대로 줘야한다. 특정 권한을 다 주고 나서 나머지를 맨 마지막에 anyRequest로 지정
                        .requestMatchers("/", "/member/login", "/member/save").permitAll()
                        .requestMatchers("/member/list").hasRole("ADMIN")
                        .requestMatchers("/member/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );
        http
                .formLogin((auth) -> auth.loginPage("/member/login")
                        .loginProcessingUrl("/loginProc")
                        .permitAll()
                );
        http
                .csrf((auth) -> auth.disable());
        return http.build();
    }
}