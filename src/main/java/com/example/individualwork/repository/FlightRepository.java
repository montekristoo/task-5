package com.example.individualwork.repository;

import com.example.individualwork.model.raw.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}