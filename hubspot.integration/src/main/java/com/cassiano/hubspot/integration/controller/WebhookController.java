package com.cassiano.hubspot.integration.controller;

import com.cassiano.hubspot.integration.controller.request.HubSpotWebhookContactRequest;
import com.cassiano.hubspot.integration.controller.response.HubSpotTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class WebhookController {

    @PostMapping("/contact")
    public ResponseEntity<HubSpotWebhookContactRequest> callback(@RequestBody HubSpotWebhookContactRequest hWContactRequest) {
        return ResponseEntity.ok(hWContactRequest);
    }
}
