package com.cassiano.hubspot.integration.service;

import com.cassiano.hubspot.integration.client.HubSpotClient;
import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import com.cassiano.hubspot.integration.controller.response.ContactsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final HubSpotClient hubSpotClient;

    public List<ContactsResponse> getAllContacts(String authorization) {
        HubSpotContactsResponse hubSpotContactsResponse = hubSpotClient.findAllContactsFromHubSpot(authorization);
        return hubSpotContactsResponse.getResults().stream().map(e ->{
            return ContactsResponse.builder()
                    .id(e.getId())
                    .email(e.getProperties().getEmail())
                    .firstName(e.getProperties().getFirstname())
                    .lastName(e.getProperties().getLastname())
                    .build();
        }).collect(Collectors.toList());
    }
}
