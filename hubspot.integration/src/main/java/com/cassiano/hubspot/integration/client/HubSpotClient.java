package com.cassiano.hubspot.integration.client;

import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hubspot-api",url = "https://api.hubapi.com/crm/v3/objects")
public interface HubSpotClient {

    @RequestLine("GET /contacts")
    @Headers("Content-Type:application/json")
    public HubSpotContactsResponse findAllContactsFromHubSpot();
}
