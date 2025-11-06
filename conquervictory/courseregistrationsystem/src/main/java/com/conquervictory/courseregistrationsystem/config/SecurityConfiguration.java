package com.conquervictory.courseregistrationsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    //     log.info("securityfilterchain called");
    //     http.cors(Customizer.withDefaults());
    //     http.csrf(customizer -> customizer.disable());
    //     http.authorizeRequests(request -> request
    //                             .antMatchers("/admin/**").hasRole("ADMIN")   // this for springboot 2.7.9, if use spring 6 use requestMatchers
    //                             .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
    //                             .antMatchers("/public/**").permitAll()
    //                             .anyRequest().authenticated());
    //    http.formLogin(Customizer.withDefaults());  // for default page
    //    http.httpBasic(Customizer.withDefaults());  // for postman hits
        
    //     //http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    //     return http.build();
    // }



    // For ui request,chatgpt suggest
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("securityfilterchain called");
        http.cors(Customizer.withDefaults());
        //http.csrf(Customizer.withDefaults());   // ✅ enable CSRF for browser UI
        http.csrf(customizer -> customizer.disable());
        http.authorizeRequests(request -> request
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
        );
        //http.formLogin(Customizer.withDefaults());  // ✅ browser login form
        http.httpBasic(Customizer.withDefaults());  // ✅ still works for Postman
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     log.info("securityfilterchain called");

    //     http
    //         .cors(Customizer.withDefaults())
    //         .csrf(csrf -> csrf.disable())
    //         .authorizeRequests(auth -> auth
    //             .anyRequest().authenticated()   // 👈 no roles, just authentication
    //         )
    //         .httpBasic(Customizer.withDefaults());  // or formLogin() if using UI

    //     http.sessionManagement(session -> session
    //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    //     return http.build();
    // }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        System.out.println("authenticationProvider called");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


    //  @Bean
    // public WebMvcConfigurer corsConfigurer() {
    //     return new WebMvcConfigurer() {
    //         @Override
    //         public void addCorsMappings(CorsRegistry registry) {
    //             registry.addMapping("/**")                         // Allow CORS for all endpoints
    //                     .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500")   // Allow requests from your frontend
    //                     .allowedMethods("*")                       // Allow all HTTP methods: GET, POST, etc.
    //                     .allowedHeaders("*")                       // Allow all headers
    //                     .allowCredentials(true);                   // Allow cookies or credentials
    //         }
    //     };
    // }

    


}
