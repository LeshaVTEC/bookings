package org.alexey.bookings.dao;

import org.alexey.bookings.dao.api.IAircraftDao;
import org.alexey.bookings.dto.Aircraft;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AircraftDao implements IAircraftDao {
    @Override
    public List<Aircraft> getAllAircrafts() {
        List<Aircraft> aircrafts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo")) {
            String savePositionSql = "SELECT aircraft_code, model, range " +
                    "FROM bookings.aircrafts_data;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(savePositionSql)) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    aircrafts.add( new Aircraft(
                                    resultSet.getString("aircraft_code"),
                                    resultSet.getString("model"),
                                    resultSet.getInt("range")
                            )
                    );
                }
                return aircrafts;
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception " + exception.getErrorCode());
            System.out.println(Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
    }
}
