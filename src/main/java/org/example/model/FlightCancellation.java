package org.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class FlightCancellation {
    private int cancellationId;
    private int flightId;
    private int reasonId;
    private Date cancellationTime;
}