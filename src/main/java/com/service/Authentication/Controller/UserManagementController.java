package com.service.Authentication.Controller;

import com.service.Authentication.Entities.User;
import com.service.Authentication.Services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class UserManagementController {
    @Autowired
    private UserManagementService _userManagementService;

   @PostMapping("/addUser")
    public ResponseEntity<String> AddUser(@RequestBody User user){
         return _userManagementService.AddUser(user);
    }
    @GetMapping("/getAll")
    public List<User> GetAll(){
        return _userManagementService.GetAll();
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable int id){
        return _userManagementService.DeleteUser(id);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<String> UpdateUser(@RequestBody User user){
        return _userManagementService.UpdateUser(user);
    }
    @GetMapping("/getUserById/{id}")
    public User GetUserById(@PathVariable int id){
        return _userManagementService.GetUserById(id);
    }

}
