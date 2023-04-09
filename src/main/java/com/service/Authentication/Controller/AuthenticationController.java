package com.service.Authentication.Controller;

import com.service.Authentication.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ResponseBody
@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationService _authenticationService;

    @PostMapping("/authenticate")
    public Map<String, String> AuthenticateUser(@RequestBody Map<String, String> user){
        return _authenticationService.AuthenticateUser(user.get("email"), user.get("password"));
    }

    @PostMapping("/isAuthenticated")
    public boolean isUserAuthenticated(@RequestBody String email){
        return _authenticationService.isUserAuthenticated(email);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String email){
        return _authenticationService.logout(email);
    }
}
