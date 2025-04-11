package com.cassiano.hubspot.integration.service;

import com.cassiano.hubspot.integration.client.HubSpotClient;
import com.cassiano.hubspot.integration.controller.response.HubSpotTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationsService {

    private final HubSpotClient hubSpotClient;

    public HubSpotTokenResponse getToken(String grantType, String clientId, String clientSecret, String redirectUri, String code) {
        return hubSpotClient.getToken(grantType, clientId, clientSecret, redirectUri, code);
    }

}
