package com.flightapp.flightdataconsumer.flightdataclient;

import java.time.Instant;

public class AircraftData {
    private String id;
    private String icao;
    private Double latitude;
    private Double longitude;
    private Integer heading;
    private Integer altitude;
    private Integer groundSpeed;
    private String squawk;
    private String aircraftCode;
    private String aircraftModel;
    private String aircraftRegistration;
    private Instant time; //TODO check what time it is
    private String originAirportIATA;
    private String destinationAirportIATA;
    private String flightNumber;
    private Integer onGround; //TODO check!
    private Integer verticalSpeed; //TODO check!
    private String callSign;
    private Integer toBeChecked; //TODO check!
    private String airlineICAO;
}
