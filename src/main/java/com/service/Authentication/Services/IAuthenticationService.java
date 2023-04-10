package com.service.Authentication.Services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IAuthenticationService {
    public Map<String, String> AuthenticateUser(String email, String password);
    public boolean isUserAuthenticated(String email);
    public ResponseEntity<String> logout(String email);

}
