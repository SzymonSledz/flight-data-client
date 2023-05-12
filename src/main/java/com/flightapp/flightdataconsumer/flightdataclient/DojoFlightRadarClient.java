package com.flightapp.flightdataconsumer.flightdataclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    public FlightsListByAirlineResponseDto fetchFlightData() {
        try {
            //TODO request parameter
            String uri = String.format("https://flight-radar1.p.rapidapi.com/flights/list-by-airline?airline=LO");

            // create headers
            HttpHeaders headers = createHeaders();
            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
            return objectMapper.readValue(result.getBody(), FlightsListByAirlineResponseDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.set(X_RAPID_API_KEY, apiToken);
        headers.set(X_RAPID_API_HOST, HOST_URI);
        return headers;
    }

}
