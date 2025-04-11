package com.cassiano.hubspot.integration.controller;

import com.cassiano.hubspot.integration.controller.response.HubSpotTokenResponse;
import com.cassiano.hubspot.integration.service.AuthenticationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationsService authenticationsService;

    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam String code) {
        return ResponseEntity.ok(code);
    }

    @PostMapping("/get-token")
    public ResponseEntity<HubSpotTokenResponse> callback(@RequestParam(name = "grant_type") String grantType,
                                                         @RequestParam(name = "client_id") String clientId,
                                                         @RequestParam(name = "client_secret") String clientSecret,
                                                         @RequestParam(name = "redirect_uri") String redirectUri,
                                                         @RequestParam String code) {
        return ResponseEntity.ok(authenticationsService.getToken(
                grantType, clientId, clientSecret, redirectUri, code
        ));
    }
    //https://api.hubapi.com/oauth/v1/token/?grant_type=authorization_code&client_id=54722c36-746c-43b7-97dd-e03bb39c4e96&client_secret=c890aaf2-00f3-43a9-8175-8d51119fe9ce&redirect_uri=http://localhost:8080/contacts/auth-callback&code=na1-0aa3-deaa-4f5c-88ab-6ab1a447937e


}
