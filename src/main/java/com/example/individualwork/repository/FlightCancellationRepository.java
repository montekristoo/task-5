package com.example.individualwork.repository;

import com.example.individualwork.model.FlightCancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightCancellationRepository extends JpaRepository<FlightCancellation, Long> {
}