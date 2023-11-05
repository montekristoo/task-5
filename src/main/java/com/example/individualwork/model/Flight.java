package com.example.individualwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int flightId;
    private int aircraftId;
    private String departureAirport;
    private String destinationAirport;
    private Date departureTime;
    private Date arrivalTime;
    private String status;
}