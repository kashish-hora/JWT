package com.jwt.example.config;


import com.jwt.example.security.JwtAuthenticationEntryPoint;
import com.jwt.example.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
    public class SecurityConfig {


        @Autowired
        private JwtAuthenticationEntryPoint point;
        @Autowired
        private JwtAuthenticationFilter filter;
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(csrf -> csrf.disable())
                    .authorizeRequests().
                    requestMatchers("/home/**").authenticated().requestMatchers("/auth/login").permitAll().requestMatchers("/auth/create-user").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
        @Bean
        public DaoAuthenticationProvider daoathenticationprovider(){
            DaoAuthenticationProvider daoathenticationprovider=new DaoAuthenticationProvider();
             daoathenticationprovider.setUserDetailsService(userDetailsService);
            daoathenticationprovider.setPasswordEncoder(passwordEncoder);
            return daoathenticationprovider;


        }


    }

