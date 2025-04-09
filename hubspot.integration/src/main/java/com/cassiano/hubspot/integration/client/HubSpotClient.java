package com.cassiano.hubspot.integration.client;

import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "hubspot-api",url = "https://api.hubapi.com/crm/v3/objects")
public interface HubSpotClient {

    @GetMapping("/contacts")
    public HubSpotContactsResponse findAllContactsFromHubSpot(@RequestHeader("Authorization") String authorization);
}
