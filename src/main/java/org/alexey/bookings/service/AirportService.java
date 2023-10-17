package org.alexey.bookings.service;

import org.alexey.bookings.dao.api.IAirportDao;
import org.alexey.bookings.dto.Airport;
import org.alexey.bookings.service.api.IAirportService;

import java.util.Collection;
import java.util.List;

public class AirportService implements IAirportService {

   private IAirportDao airportDao;

    public AirportService(IAirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public List<Airport> getAllAirports() {

        return airportDao.getAllAirports();
    }
}
