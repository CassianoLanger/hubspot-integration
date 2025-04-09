package com.cassiano.hubspot.integration.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HubSpotContactsResponse {

    private List<HubSpotContact> results;
}
