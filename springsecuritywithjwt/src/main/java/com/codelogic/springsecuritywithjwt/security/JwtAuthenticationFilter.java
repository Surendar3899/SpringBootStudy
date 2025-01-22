package com.codelogic.springsecuritywithjwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codelogic.springsecuritywithjwt.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    
    public JwtAuthenticationFilter(JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        System.out.println("JwtAuthenticationFilter constructor called");
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("doFilterInternal called");        
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer")){
            try{
                System.out.println("doFilterInternal is");
                token = token.substring(7);
                String username = jwtUtil.extractUserName(token);
                if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    System.out.println("if >>>>>");
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                    if(jwtUtil.isTokenValid(token)){
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);


                    }
                }else{
                    System.out.println("else.....");
                    System.out.println(username);
                    System.out.println(SecurityContextHolder.getContext().getAuthentication() == null);
                }
            }catch(Exception ex){
                System.out.println("Exception Caught: " + ex);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"Invalid Token\"}");
                return;
            }
        }else{
            System.out.println("doFilterInternal else"); 
        }
        try{
        filterChain.doFilter(request,response);
        }catch(Exception e){
            System.out.println("Exception caught "+e);
        }
    }

}
