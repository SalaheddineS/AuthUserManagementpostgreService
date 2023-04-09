package com.service.Authentication.Controller;

import com.service.Authentication.Entities.User;
import com.service.Authentication.Services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class AuthenticationController {
    @Autowired
    private AuthenticationServices _authenticationServices;

   @PostMapping("/addUser")
    public ResponseEntity<String> AddUser(@RequestBody User user){
         return _authenticationServices.AddUser(user);
    }
    @GetMapping("/getAll")
    public List<User> GetAll(){
        return _authenticationServices.GetAll();
    }

}
