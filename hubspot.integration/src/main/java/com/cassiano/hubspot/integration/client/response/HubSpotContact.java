package com.cassiano.hubspot.integration.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HubSpotContact {
    private String id;
    private Properties properties;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    private boolean archived;

    @Data
    public static class Properties {
        private String createdate;
        private String email;
        private String firstname;

        @JsonProperty("hs_object_id")
        private String hsObjectId;

        private String lastmodifieddate;
        private String lastname;
    }
}
