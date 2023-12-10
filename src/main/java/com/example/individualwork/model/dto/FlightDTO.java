package com.example.individualwork.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FlightDTO {
    private int flightId;
    private int aircraftId;
    private String departureAirport;
    private String destinationAirport;
    private Date departureTime;
    private Date arrivalTime;
    private String status;
}