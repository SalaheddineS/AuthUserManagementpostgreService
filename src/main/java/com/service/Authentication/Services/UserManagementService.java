package com.service.Authentication.Services;

import com.service.Authentication.Configuration.SecurityConfig;
import com.service.Authentication.Entities.User;
import com.service.Authentication.Repositories.PostGreRepo;
import com.service.Authentication.Utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserManagementService implements IUserManagementService {
    @Autowired
    private PostGreRepo _postGreRepo;
    @Autowired
    private SecurityConfig _securityConfig;
    @Autowired
    private JwtUtil _jwtUtil;

    @Override
    public ResponseEntity<String> AddUser(User user){
        try{
            if(_postGreRepo.existsByEmail(user.getEmail().toUpperCase())){
                throw new RuntimeException("User already exists");
            }
            user.setPassword(_securityConfig.passwordEncoder().encode(user.getPassword()));
            user.setAdmin(false);
            user.setEmail(user.getEmail().toUpperCase());
            _postGreRepo.save(user);
            return ResponseEntity.ok("User added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error adding user");
        }

    }
    @Override
    public List<User> GetAll(){

        try{

            return _postGreRepo.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error getting users");
        }
    }
    @Override
    public ResponseEntity<String> DeleteUser(int id){
        try{
            _postGreRepo.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error deleting user");
        }
    }
    @Override
    public ResponseEntity<String> UpdateUser(User user){
        try{
            user.setEmail(user.getEmail().toUpperCase());
            System.out.println(user.getPassword());
            String password=_postGreRepo.findByEmail(user.getEmail()).getPassword();
            if(user.getPassword().length()<5){
                user.setPassword(password);
                _postGreRepo.save(user);
                return ResponseEntity.ok("User updated successfully but kept the same password");
            }
            if(user.getPassword().equals(password)){
                _postGreRepo.save(user);
                return ResponseEntity.ok("User updated successfully");
            }
            user.setPassword(_securityConfig.passwordEncoder().encode(user.getPassword()));
            _postGreRepo.save(user);
            return ResponseEntity.ok("User updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error updating user");
        }
    }
    @Override
    public User GetUserById(int id){

        try{
            return _postGreRepo.findById(id).get();
        }catch (Exception e){
            throw new RuntimeException("Error getting user");
        }
    }
}
