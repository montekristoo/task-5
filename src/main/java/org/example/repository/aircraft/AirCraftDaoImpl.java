package org.example.repository.aircraft;

import org.example.exception.DatabaseConnectionException;
import org.example.model.AirCraft;
import org.example.service.DatabaseExecutorService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cebotari Viktor
 */
public class AirCraftDaoImpl implements AircraftDAO {
    private final DatabaseExecutorService executorService;

    public AirCraftDaoImpl(Connection connection) {
        this.executorService = new DatabaseExecutorService(connection);
    }

    @Override
    public List<AirCraft> findAllAirCrafts() {
        String sql = "SELECT * FROM aircraft";
        ResultSet resultSet = executorService.executeQuery(sql);
        List<AirCraft> airCrafts = new ArrayList<>();
        try {
            while (resultSet.next()) airCrafts.add(getAirCraft(resultSet));
            return airCrafts;
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }

    @Override
    public AirCraft findAirCraftByName(String name) {
        String sql = String.format("SELECT * FROM aircraft WHERE aircraft_name = '%s'", name);
        return getAirCraft(executorService.executeQuery(sql));
    }

    private AirCraft getAirCraft(ResultSet resultSet) {
        try {
            AirCraft aircraft = new AirCraft();
            aircraft.setAircraftId(resultSet.getInt("aircraft_id"));
            aircraft.setAircraftName(resultSet.getString("aircraft_name"));
            aircraft.setCapacity(resultSet.getInt("capacity"));
            aircraft.setRangeKm(resultSet.getInt("range_km"));
            return aircraft;
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }
}
