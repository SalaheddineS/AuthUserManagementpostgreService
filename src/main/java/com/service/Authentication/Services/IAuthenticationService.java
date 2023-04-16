package com.service.Authentication.Services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IAuthenticationService {
    public ResponseEntity<?> AuthenticateUser(String email, String password);
    public boolean isUserAuthenticated(String email);
    public ResponseEntity<String> logout(String email);
    public boolean isAdministrator(String email);
    public String getEmailFromToken(String token);
}
