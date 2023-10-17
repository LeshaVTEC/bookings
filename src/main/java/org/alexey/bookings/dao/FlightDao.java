package org.alexey.bookings.dao;

import org.alexey.bookings.dao.api.IFlightDao;
import org.alexey.bookings.dto.Flight;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightDao implements IFlightDao {
    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo")) {
            String savePositionSql = "SELECT flight_id, flight_no, scheduled_departure, scheduled_arrival, " +
                    "departure_airport, arrival_airport, status, aircraft_code, actual_departure, actual_arrival " +
                    "FROM bookings.flights;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(savePositionSql)) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    flights.add(returnFlight(resultSet));
                }
                return flights;
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception " + exception.getErrorCode());
            System.out.println(Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
    }
    @Override
    public List<Flight> getFlightsWithFilters(Pageable pageable){
        return getFlightsWithFilters(null, pageable);
    }
    @Override
    public List<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable){
            String savePositionSql = """
                    SELECT flight_id, flight_no, scheduled_departure, scheduled_arrival, 
                    departure_airport, arrival_airport, status, aircraft_code, actual_departure, actual_arrival 
                    FROM bookings.flights 
                    """;
            List<Object> params = new ArrayList<>();
            if (filter != null){
                StringBuilder sqlBuilder = new StringBuilder();

                boolean needSeparator = false;
                if(filter.getScheduledDeparture() != null){
                    if(needSeparator){
                        sqlBuilder.append(" AND ");
                    } else {
                        needSeparator = true;
                    }
                    sqlBuilder.append("scheduled_departure >= ? AND scheduled_departure < ?");
                    params.add(filter.getScheduledDeparture());
                    params.add(filter.getScheduledDeparture().plusDays(1));
                }
                if(filter.getScheduledArrival() != null){
                    if(needSeparator){
                        sqlBuilder.append(" AND ");
                    } else {
                        needSeparator = true;
                    }
                    sqlBuilder.append("scheduled_arrival >= ? AND scheduled_arrival < ?");
                    params.add(filter.getScheduledArrival());
                    params.add(filter.getScheduledArrival().plusDays(1));
                }
                if(filter.getDepartureAirport() != null){
                    if(needSeparator){
                        sqlBuilder.append(" AND ");
                    } else {
                        needSeparator = true;
                    }
                    sqlBuilder.append("departure_airport = ?");
                    params.add(filter.getDepartureAirport());
                }
                if(filter.getArrivalAirport() != null){
                    if(needSeparator){
                        sqlBuilder.append(" AND ");
                    } else {
                        needSeparator = true;
                    }
                    sqlBuilder.append("arrival_airport = ?");
                    params.add(filter.getArrivalAirport());
                }
                if(filter.getStatus() != null){
                    if(needSeparator){
                        sqlBuilder.append(" AND ");
                    } else {
                        needSeparator = true;
                    }
                    sqlBuilder.append("status = ?");
                    params.add(filter.getStatus());
                }

                if(sqlBuilder.length() > 0){
                    sqlBuilder.insert(0, " WHERE ");
                    savePositionSql += sqlBuilder.toString();
                }
            }
        if(pageable != null){
            int size = pageable.getSize();
            int page = pageable.getPage();

            savePositionSql += " LIMIT ? OFFSET ?";
            params.add(size);
            params.add(((page - 1) * size));
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo")) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(savePositionSql)) {
                int index = 1;
                for (Object param : params) {
                    preparedStatement.setObject(index++, param);
                }
                preparedStatement.execute();
                try(ResultSet resultSet = preparedStatement.getResultSet()){
                    List<Flight> flights = new ArrayList<>();
                    while (resultSet.next()){
                        flights.add(returnFlight(resultSet));
                    }

                    return flights;
                }
            }
        } catch (SQLException exception) {
            System.out.println("SQL Exception " + exception.getErrorCode());
            System.out.println(Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
        //scheduled_departure=2017-01-10&scheduled_arrival=2017-01-20&departure_airport=DME&arrival_airport=LED&status=Arrived
        //flights/filter?scheduled_departure=2017-01-10&scheduled_arrival=2017-01-20&departure_airport=DME&arrival_airport=LED&status=Arrived
    }

    public Integer getCount(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo")) {
            String savePositionSql = "SELECT count(*) FROM bookings.flights;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(savePositionSql)){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                 return resultSet.getInt(1);
                }
            }
            return 0;
        }
        catch (SQLException exception){
            System.out.println("SQL Exception " + exception.getErrorCode());
            System.out.println(Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
    }

    public Flight returnFlight(ResultSet resultSet) throws SQLException{
        Flight flight = new Flight(
                resultSet.getInt("flight_id"),
                resultSet.getString("flight_no"),
                resultSet.getTimestamp("scheduled_departure").toLocalDateTime(),
                resultSet.getTimestamp("scheduled_arrival").toLocalDateTime(),
                resultSet.getString("departure_airport"),
                resultSet.getString("arrival_airport"),
                resultSet.getString("status"),
                resultSet.getString("aircraft_code"),
                getActualDeparture(resultSet),
                getActualArrival(resultSet)
        );
        return flight;
    }

    private static LocalDateTime getActualDeparture(ResultSet resultSet) throws SQLException{
        if (resultSet.getTimestamp("actual_departure") == null){
            return null;
        }
        return resultSet.getTimestamp("actual_departure").toLocalDateTime();
    }

    private static LocalDateTime getActualArrival(ResultSet resultSet) throws SQLException{
        if (resultSet.getTimestamp("actual_arrival") == null){
            return null;
        }
        return resultSet.getTimestamp("actual_arrival").toLocalDateTime();
    }

}
