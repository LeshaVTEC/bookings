package org.alexey.bookings.dao.api;

import org.alexey.bookings.dto.Aircraft;

import java.util.List;

public interface IAircraftDao {
    List<Aircraft> getAllAircrafts();
}
