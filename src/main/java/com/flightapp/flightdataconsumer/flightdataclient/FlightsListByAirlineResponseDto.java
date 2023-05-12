package com.flightapp.flightdataconsumer.flightdataclient;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FlightsListByAirlineResponseDto {
    @JsonProperty("full_count")
    private int fullCount;
    @JsonProperty("version")
    private int version;
    @JsonProperty("aircraft")
    private List<List<String>> aircraftData;
}
