package com.flightapp.flightdataconsumer.flightdataclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightapp.flightdataconsumer.flightdataclient.dto.FlightData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class DojoFlightRadarClient implements FlightDataClient {
    private static final String X_RAPID_API_HOST = "X-RapidAPI-Host";
    private static final String X_RAPID_API_KEY = "X-RapidAPI-Key";
    private static final String HOST_URI = "flight-radar1.p.rapidapi.com";
    private final String apiToken;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    DojoFlightRadarClient(@Value("${flight-data-dojo-api.api-token}") String apiToken, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.apiToken = apiToken;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public FlightData fetchFlightData() {
        return null;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.set(X_RAPID_API_KEY, apiToken);
        headers.set(X_RAPID_API_HOST, HOST_URI);
        return headers;
    }

}
