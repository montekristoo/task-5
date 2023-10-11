package org.example.repository.aircraft;

import org.example.model.AirCraft;

import java.util.List;

/**
 * @author Cebotari Viktor
 */
public interface AircraftDAO {
    List<AirCraft> findAllAirCrafts();

    AirCraft findAirCraftByName(String name);
}