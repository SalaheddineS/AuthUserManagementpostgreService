package com.service.Authentication.Services;

import com.service.Authentication.Configuration.SecurityConfig;
import com.service.Authentication.Entities.User;
import com.service.Authentication.Repositories.PostGreRepo;
import com.service.Authentication.Utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String, String> AuthenticateUser(String email, String password){
        boolean userExists = postGreRepo.existsByEmail(email);
        if (!userExists){
            throw new RuntimeException("User does not exist");
        }
        User user = postGreRepo.findByEmail(email);
        if(!securityConfig.passwordEncoder().matches(password, user.getPassword())){
            throw new RuntimeException("Incorrect password");
        }
        Map<String, String> token = new HashMap<>();
        token.put("token", jwtUtil.generateToken(user.getEmail(), user.getId()));
        user.setToken(token.get("token"));
        postGreRepo.save(user);
        return token;
    }
    @Override
    public boolean isUserAuthenticated(String email){
        boolean userExists = postGreRepo.existsByEmail(email);
        if (!userExists){
            throw new RuntimeException("User does not exist");
        }
        User user = postGreRepo.findByEmail(email);
        return jwtUtil.validateToken(user.getToken());
    }
    @Override
    public ResponseEntity<String> logout(String email){
        boolean userExists = postGreRepo.existsByEmail(email);
        if (!userExists){
            throw new RuntimeException("User does not exist");
        }
        User user = postGreRepo.findByEmail(email);
        user.setToken(null);
        postGreRepo.save(user);
        return ResponseEntity.ok("User logged out");
    }
}
