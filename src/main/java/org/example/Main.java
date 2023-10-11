package org.example;

import org.example.config.ConnectionFactory;
import org.example.exception.DatabaseConnectionException;
import org.example.model.Database;
import org.example.repository.aircraft.AirCraftDaoImpl;
import org.example.repository.aircraft.AircraftDAO;
import org.example.repository.cancellation.CancellationReasonDAO;
import org.example.repository.cancellation.CancellationReasonDaoImpl;
import org.example.repository.flight.FlightDAO;
import org.example.repository.flight.FlightDaoImpl;
import org.example.util.Constants;
import org.example.util.FlightStatus;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        execute();
    }

    /**
     * This method is used to execute the queries.
     * <br/>
     * It uses the ConnectionFactory class to get a connection to the database.
     * <br/>
     * It uses the Database class to get the database properties.
     * <br/>
     * It uses the DAO classes to execute the queries.
     */
    private static void execute() {
        try (Connection connection = ConnectionFactory.getConnection(getDatabase())) {

            AircraftDAO aircraftDAO = new AirCraftDaoImpl(connection);
            aircraftDAO.findAllAirCrafts().forEach(System.out::println);

            CancellationReasonDAO cancellationReasonDAO = new CancellationReasonDaoImpl(connection);
            System.out.println(cancellationReasonDAO.findCancellationReasonById(1));

            FlightDAO flightDAO = new FlightDaoImpl(connection);
            flightDAO.findFlightsByStatus(FlightStatus.SCHEDULED.name()).forEach(System.out::println);
        } catch (Exception e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }


    private static Database getDatabase() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/main/resources/application.yml"));
            String url = properties.getProperty(Constants.URL);
            String username = properties.getProperty(Constants.USERNAME);
            String password = properties.getProperty(Constants.PASSWORD);
            String driver = properties.getProperty(Constants.DRIVER);
            return new Database(url, username, password, driver);
        } catch (Exception e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }
}