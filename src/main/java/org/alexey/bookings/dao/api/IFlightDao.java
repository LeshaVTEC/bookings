package org.alexey.bookings.dao.api;

import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;
import org.alexey.bookings.entity.FlightEntity;

import java.util.List;

public interface IFlightDao {
    List<FlightEntity> getAllFlights();
    List<FlightEntity> getFlightsWithFilters(Pageable pageable);
    List<FlightEntity> getFlightsWithFilters(FlightFilter filter, Pageable pageable);
}
