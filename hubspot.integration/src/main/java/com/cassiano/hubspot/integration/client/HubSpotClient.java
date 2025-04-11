package com.cassiano.hubspot.integration.client;

import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import com.cassiano.hubspot.integration.controller.request.HubSpotContactRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "hubspot-api",url = "https://api.hubapi.com/crm/v3/objects")
public interface HubSpotClient {

    @GetMapping("/contacts")
    public HubSpotContactsResponse findAllContactsFromHubSpot(@RequestHeader("Authorization") String authorization);

    @PostMapping("/contacts")
    public HubSpotContactRequest saveContact(@RequestHeader("Authorization") String authorization,
                                             @RequestBody HubSpotContactRequest contactRequest);
}
