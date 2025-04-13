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
}
