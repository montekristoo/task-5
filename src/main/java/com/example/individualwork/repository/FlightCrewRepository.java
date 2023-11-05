package com.example.individualwork.repository;

import com.example.individualwork.model.FlightCrew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightCrewRepository extends JpaRepository<FlightCrew, Long> {
}