package com.service.Authentication.Services;

import com.service.Authentication.Configuration.SecurityConfig;
import com.service.Authentication.Entities.User;
import com.service.Authentication.Repositories.PostGreRepo;
import com.service.Authentication.Utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private PostGreRepo postGreRepo;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public ResponseEntity<?> AuthenticateUser(String email, String password) {
        email = email.toLowerCase();
        boolean userExists = postGreRepo.existsByEmail(email);
        if (!userExists) {
            throw new RuntimeException("User does not exist");
        }
        User user = postGreRepo.findByEmail(email);
        if (!securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        String token = jwtUtil.generateToken(user.getEmail(), user.getId());
        user.setToken(token);
        postGreRepo.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",  token);
        return ResponseEntity.ok().headers(headers).build();
    }

    @Override
    public boolean isUserAuthenticated(String token){
        String email=jwtUtil.getEmailFromToken(token);
        email = email.toLowerCase();
        User user = postGreRepo.findByEmail(email);
        if(jwtUtil.validateToken(user.getToken()) && user.getToken().equals(token)){
            return true;
        }
        return false;
    }
    @Override
    public ResponseEntity<String> logout(String token){
         if(!jwtUtil.validateToken(token)){
             throw new RuntimeException("Invalid token");
         }
            User user = postGreRepo.findByEmail(jwtUtil.getEmailFromToken(token).toLowerCase());
            user.setToken(null);
            postGreRepo.save(user);
            return ResponseEntity.ok("User logged out successfully");
    }

    @Override
    public boolean isAdministrator(String token) {
        if(!jwtUtil.validateToken(token)){
            throw new RuntimeException("Invalid token");
        }
        User user = postGreRepo.findByEmail(jwtUtil.getEmailFromToken(token).toLowerCase());
        return user.isAdmin();
    }

    @Override
    public String getEmailFromToken(String token){
        return jwtUtil.getEmailFromToken(token).toLowerCase();
    }
}
