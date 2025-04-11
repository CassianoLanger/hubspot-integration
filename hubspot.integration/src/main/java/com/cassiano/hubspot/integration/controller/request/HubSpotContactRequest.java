package com.cassiano.hubspot.integration.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HubSpotContactRequest {

    private Properties properties;

    @Data
    @Builder
    public static class Properties {
        private String email;
        private String firstname;
        private String lastname;
    }
}
