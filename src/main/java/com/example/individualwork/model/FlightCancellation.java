package com.example.individualwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class FlightCancellation {
    @Id
    @GeneratedValue
    private int cancellationId;
    private int flightId;
    private int reasonId;
    private Date cancellationTime;
}