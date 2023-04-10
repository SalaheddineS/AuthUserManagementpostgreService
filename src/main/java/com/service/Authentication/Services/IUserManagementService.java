package com.service.Authentication.Services;

import com.service.Authentication.Entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserManagementService {
    public ResponseEntity<String> AddUser(User user);
    public List<User> GetAll();
    public ResponseEntity<String> DeleteUser(int id);
    public ResponseEntity<String> UpdateUser(User user);
    public User GetUserById(int id);
}
