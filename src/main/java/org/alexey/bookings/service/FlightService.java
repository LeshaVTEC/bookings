package org.alexey.bookings.service;

import org.alexey.bookings.dao.api.IFlightDao;
import org.alexey.bookings.dto.Flight;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;
import org.alexey.bookings.service.api.IFlightService;

import java.time.LocalDate;
import java.util.List;

public class FlightService implements IFlightService {

    IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    @Override
    public List<Flight> getFlightsWithFilters(Pageable pageable) {
        return flightDao.getFlightsWithFilters(pageable);
    }

    @Override
    public List<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable) {
        return flightDao.getFlightsWithFilters(filter, pageable);
    }
}
