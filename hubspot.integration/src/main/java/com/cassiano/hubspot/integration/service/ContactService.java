package com.cassiano.hubspot.integration.service;

import com.cassiano.hubspot.integration.client.HubSpotClient;
import com.cassiano.hubspot.integration.client.response.HubSpotContactsResponse;
import com.cassiano.hubspot.integration.controller.request.ContactRequest;
import com.cassiano.hubspot.integration.controller.request.HubSpotContactRequest;
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

    public ContactRequest saveContact(String authorization, ContactRequest contact) {

        HubSpotContactRequest.Properties build = HubSpotContactRequest.Properties.builder()
                .firstname(contact.getFirstName())
                .lastname(contact.getLastName())
                .email(contact.getEmail())
                .build();

        HubSpotContactRequest.Properties properties = hubSpotClient.saveContact(authorization,
                HubSpotContactRequest.builder().properties(build).build()).getProperties();

        return ContactRequest.builder()
                .firstName(properties.getFirstname())
                .lastName(properties.getLastname())
                .email(properties.getEmail())
                .build();
    }
}
