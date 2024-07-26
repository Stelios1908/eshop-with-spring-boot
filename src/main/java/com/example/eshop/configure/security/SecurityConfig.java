package com.example.eshop.configure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;



@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated() // Απαιτεί αυθεντικοποίηση για όλες τις διαδρομές
                )
                .formLogin(formLogin ->
                        formLogin
                                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                                .permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .logout(logout ->
                        logout
                                .permitAll()
                )
                .csrf(csrf ->
                        csrf
                                .disable()
                );


        return http.build();
    }



}
