package org.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class Flight {
    private int flightId;
    private int aircraftId;
    private String departureAirport;
    private String destinationAirport;
    private Date departureTime;
    private Date arrivalTime;
    private String status;
}