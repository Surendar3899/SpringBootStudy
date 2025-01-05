package com.codelogic.springsecuritywithjwt.security;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.codelogic.springsecuritywithjwt.entity.Role;
import com.codelogic.springsecuritywithjwt.entity.User;
import com.codelogic.springsecuritywithjwt.repository.UserRepository;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

   // secret key
   private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
   
   
   // expiration time
   private final int jwtExpirationMs = 86400000;
   
   private UserRepository userRepository;

   public JwtUtil(UserRepository userRepository){
    this.userRepository = userRepository;
   }

   //Generate Token
   public String generateToken(String username){
      System.out.println("jwt util generateToken called");
      String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
      System.out.println("Secret Key (Base64 Encoded): " + encodedKey);
      Optional<User> user = userRepository.findByUsername(username);
      Set<Role> roles = user.get().getRoles();
      

      // Add roles to the token
      return Jwts.builder().setSubject(username).
         claim("roles",roles.stream().map(role -> role.getName()).collect(Collectors.joining(",")))
         .setIssuedAt(new Date())
         .setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
         .signWith(secretKey).compact();
   }

   //Extract Username
   public String extractUserName(String token){
      System.out.println("jwtutill extractUserName called");
      String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
      System.out.println("Secret Key (Base64 Encoded): " + encodedKey);
      return Jwts.parserBuilder().
         setSigningKey(secretKey).build().
         parseClaimsJws(token).getBody().
         getSubject();

   }


   //Extract roles
   public Set<String> extractRoles(String token){
      System.out.println("jwtutill extractRoles called");
      String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
      System.out.println("Secret Key (Base64 Encoded): " + encodedKey);
      String roleString = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("roles",String.class);
      //return Set.of(roleString);
      return Collections.singleton(roleString);
   }


   // Token Validation

   public boolean isTokenValid(String token){
      System.out.println("jwtutill isTokenValid called");
      String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
      System.out.println("Secret Key (Base64 Encoded): " + encodedKey);
      try{
         Jwts.parserBuilder().
           setSigningKey(secretKey).build().
           parseClaimsJws(token);
           return true;

      }catch(JwtException | IllegalArgumentException e){
         System.out.println(e);
         return false; 
      }
   }
}
