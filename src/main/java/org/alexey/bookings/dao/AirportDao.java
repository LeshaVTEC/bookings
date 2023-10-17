package org.alexey.bookings.dao;

import org.alexey.bookings.dao.api.IAirportDao;
import org.alexey.bookings.dto.Airport;
import org.postgresql.geometric.PGpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportDao implements IAirportDao {
    @Override
    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo")) {
            String savePositionSql = "SELECT airport_code, airport_name, city, coordinates, timezone " +
                    "FROM bookings.airports_data;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(savePositionSql)) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    airports.add( new Airport(
                                    resultSet.getString("airport_code"),
                                    resultSet.getString("airport_name"),
                                    resultSet.getString("city"),
                                    resultSet.getObject("coordinates", PGpoint.class),
                                    resultSet.getString("timezone")
                            )
                    );
                }
                return airports;
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception " + exception.getErrorCode());
            System.out.println(Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
    }
}
