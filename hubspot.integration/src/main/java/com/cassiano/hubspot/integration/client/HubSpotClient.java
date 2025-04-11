package com.cassiano.hubspot.integration.client;

import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import com.cassiano.hubspot.integration.controller.request.HubSpotContactRequest;
import com.cassiano.hubspot.integration.controller.response.HubSpotTokenResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hubspot-api",url = "https://api.hubapi.com")
public interface HubSpotClient {

    @GetMapping("/crm/v3/objects/contacts")
    public HubSpotContactsResponse findAllContactsFromHubSpot(@RequestHeader("Authorization") String authorization);

    @PostMapping("/crm/v3/objects/contacts")
    public HubSpotContactRequest saveContact(@RequestHeader("Authorization") String authorization,
                                             @RequestBody HubSpotContactRequest contactRequest);

    @PostMapping("/oauth/v1/token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    HubSpotTokenResponse getToken(@RequestParam(name = "grant_type") String grantType,
                                  @RequestParam(name = "client_id") String clientId,
                                  @RequestParam(name = "client_secret") String clientSecret,
                                  @RequestParam(name = "redirect_uri") String redirectUri,
                                  @RequestParam String code);

}
