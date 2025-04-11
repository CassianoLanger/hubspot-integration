package com.cassiano.hubspot.integration.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HubSpotWebhookContactRequest {

    private HubSpotContactRequest.Properties properties;

    @Data
    @Builder
    public static class Properties {
        @JsonProperty(value = "hs_object_id")
        private String id;
        private String email;
        private String firstname;
        private String lastname;
    }
}
