package com.cassiano.hubspot.integration.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
