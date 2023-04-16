package com.service.Authentication.Controller;

import com.service.Authentication.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ResponseBody
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")

public class AuthenticationController {
    @Autowired
    private AuthenticationService _authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> AuthenticateUser(@RequestBody Map<String, String> user){
        return _authenticationService.AuthenticateUser(user.get("email"), user.get("password"));
    }

    @PostMapping("/isAuthenticated")
    public boolean isUserAuthenticated(@RequestHeader("token") String token){
        return _authenticationService.isUserAuthenticated(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("token") String token){
        return _authenticationService.logout(token);
    }

    @PostMapping("/isAdministrator")
    public boolean isAdministrator(@RequestHeader("token") String token){
        return _authenticationService.isAdministrator(token);
    }

    @PostMapping("/getEmailFromToken")
    public String getEmailFromToken(@RequestHeader("token") String token){
        return _authenticationService.getEmailFromToken(token);
    }

}
