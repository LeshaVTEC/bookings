package org.alexey.bookings.service;

import org.alexey.bookings.dao.api.IAircraftDao;
import org.alexey.bookings.dto.Aircraft;
import org.alexey.bookings.service.api.IAircraftService;

import java.util.List;

public class AircraftService implements IAircraftService {

    IAircraftDao aircraftDao;

    public AircraftService(IAircraftDao aircraftDao) {
        this.aircraftDao = aircraftDao;
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return this.aircraftDao.getAllAircrafts();
    }
}
