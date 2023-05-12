package com.flightapp.flightdataconsumer.flightdataclient;

public interface FlightDataClient {
    //TODO mapowanie na flightdata i poprawne dtosy
    FlightsListByAirlineResponseDto fetchFlightData();
}
