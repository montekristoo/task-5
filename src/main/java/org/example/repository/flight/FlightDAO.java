package org.example.repository.flight;

import org.example.model.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> findFlightsByStatus(String status);
}