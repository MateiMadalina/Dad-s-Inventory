package com.codecool.dadsinventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/js/**")
                        .permitAll()
                        .requestMatchers("/css/**")
                        .permitAll()
                        .requestMatchers("/webjars/**")
                        .permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/item/details/**").hasRole("DAD")
                        .requestMatchers("/home/privacy").hasRole("MOM")
                        .anyRequest().authenticated()
                )
                .oauth2Login(form->form.defaultSuccessUrl("/"))
                .formLogin(form->form.defaultSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails dad = User.withUsername("dad")
                        .password(passwordEncoder.encode("dad"))
                        .roles("DAD")
                        .build();
        UserDetails mom = User.withUsername("mom")
                .password(passwordEncoder.encode("mom"))
                .roles("MOM")
                .build();

        return new InMemoryUserDetailsManager(dad,mom);
    }
}





