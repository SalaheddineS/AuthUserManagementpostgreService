package com.service.Authentication.Services;

import com.service.Authentication.Configuration.SecurityConfig;
import com.service.Authentication.Entities.User;
import com.service.Authentication.Repositories.PostGreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServices {
    @Autowired
    private PostGreRepo _postGreRepo;
    @Autowired
    private SecurityConfig _securityConfig;

    public ResponseEntity<String> AddUser(User user){
        try{
            user.setPassword(_securityConfig.passwordEncoder().encode(user.getPassword()));
            System.out.println(user.getPassword());
            _postGreRepo.save(user);
            return ResponseEntity.ok("User added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error adding user");
        }

    }
    public List<User> GetAll(){
        try{
            return _postGreRepo.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error getting users");
        }
    }

}
