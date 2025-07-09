package com.example.springsecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        log.info("securityfilterchain called");
        /*  step 1: csrf disable
                   same site strict
                   session - stateless
            step 2: functional interface and lambda expression       

                   */
        http.csrf(customizer -> customizer.disable());
        http.authorizeRequests(request -> request.anyRequest().authenticated());
        //http.formLogin(Customizer.withDefaults());  // for default page
        http.httpBasic(Customizer.withDefaults());  // for postman hits
        
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users = new ArrayList<>();
        UserDetails user1 = User.withDefaultPasswordEncoder().username("surendaruser").password("1357").roles("USER").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("susi").password("13579").roles("USER").build();
        UserDetails user3 = User.withDefaultPasswordEncoder().username("Aravind").password("1357911").roles("USER").build();
        users.add(user1);
        users.add(user2);
        users.add(user3);
 
         return new InMemoryUserDetailsManager(users);        // collection concept
        //return new InMemoryUserDetailsManager(user1,user2,user3);  // varargs concept

    }


}
