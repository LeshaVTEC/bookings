package org.alexey.bookings.dao.api;

import org.alexey.bookings.dto.Flight;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IFlightDao {
    List<Flight> getAllFlights();
    List<Flight> getFlightsWithFilters(Pageable pageable);
    List<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable);
}
