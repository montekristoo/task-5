package org.example.repository.flight;

import org.example.exception.DatabaseConnectionException;
import org.example.model.Flight;
import org.example.service.DatabaseExecutorService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cebotari Viktor
 * @since 12.10.2023
 */
public class FlightDaoImpl implements FlightDAO {
    private final DatabaseExecutorService executorService;

    public FlightDaoImpl(Connection connection) {
        this.executorService = new DatabaseExecutorService(connection);
    }

    @Override
    public List<Flight> findFlightsByStatus(String status) {
        String sql = String.format("SELECT * FROM flight WHERE status = '%s'", status);
        ResultSet resultSet = executorService.executeQuery(sql);
        List<Flight> flights = new ArrayList<>();
        try {
            while (resultSet.next()) flights.add(getFlight(resultSet));
            return flights;
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }

    private Flight getFlight(ResultSet resultSet) {
        try {
            Flight flight = new Flight();
            flight.setFlightId(resultSet.getInt("flight_id"));
            flight.setAircraftId(resultSet.getInt("aircraft_id"));
            flight.setDepartureAirport(resultSet.getString("departure_airport"));
            flight.setDestinationAirport(resultSet.getString("destination_airport"));
            flight.setDepartureTime(resultSet.getTimestamp("departure_time"));
            flight.setArrivalTime(resultSet.getTimestamp("arrival_time"));
            flight.setStatus(resultSet.getString("status"));
            return flight;
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }
}