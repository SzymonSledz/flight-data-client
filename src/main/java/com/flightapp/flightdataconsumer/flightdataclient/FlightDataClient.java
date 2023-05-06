package com.flightapp.flightdataconsumer.flightdataclient;

import com.flightapp.flightdataconsumer.flightdataclient.dto.FlightData;

public interface FlightDataClient {
    FlightData fetchFlightData();
}
