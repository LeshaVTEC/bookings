package org.alexey.bookings.service;

import org.alexey.bookings.dao.api.IFlightDao;
import org.alexey.bookings.dto.Flight;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;
import org.alexey.bookings.service.api.IFlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService implements IFlightService {

    IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights().stream()
                .map(flightEntity -> new Flight(flightEntity.getFlight_id(),
                        flightEntity.getFlight_no(),
                        flightEntity.getScheduled_departure(),
                        flightEntity.getScheduled_arrival(),
                        flightEntity.getDeparture_airport(),
                        flightEntity.getArrival_airport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraft_code(),
                        flightEntity.getActual_departure(),
                        flightEntity.getActual_arrival()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightsWithFilters(Pageable pageable) {
        return flightDao.getFlightsWithFilters(pageable).stream()
                .map(flightEntity -> new Flight(flightEntity.getFlight_id(),
                        flightEntity.getFlight_no(),
                        flightEntity.getScheduled_departure(),
                        flightEntity.getScheduled_arrival(),
                        flightEntity.getDeparture_airport(),
                        flightEntity.getArrival_airport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraft_code(),
                        flightEntity.getActual_departure(),
                        flightEntity.getActual_arrival()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightsWithFilters(FlightFilter filter, Pageable pageable) {
        return flightDao.getFlightsWithFilters(filter, pageable).stream()
                .map(flightEntity -> new Flight(flightEntity.getFlight_id(),
                        flightEntity.getFlight_no(),
                        flightEntity.getScheduled_departure(),
                        flightEntity.getScheduled_arrival(),
                        flightEntity.getDeparture_airport(),
                        flightEntity.getArrival_airport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraft_code(),
                        flightEntity.getActual_departure(),
                        flightEntity.getActual_arrival()))
                .collect(Collectors.toList());
    }
}
