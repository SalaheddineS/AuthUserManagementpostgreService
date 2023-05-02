package com.service.Authentication.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ResponseBody
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
public class OAuth2Controller {

    private final OAuth2AuthorizedClientService authorizedClientService;


    public OAuth2Controller(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/login/oauth2/callback/google")
    public String googleLogin(RedirectAttributes redirectAttributes,
                              @AuthenticationPrincipal OAuth2AuthenticationToken authentication) {
        // Get the authorized client for the authenticated user
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());

        // Get the user's access token
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

        // Use the access token to retrieve the user's information from Google
        // ...

        // Redirect the user to a page in your application
        redirectAttributes.addFlashAttribute("message", "You have successfully logged in with Google!");
        return "redirect:/home";
    }
}