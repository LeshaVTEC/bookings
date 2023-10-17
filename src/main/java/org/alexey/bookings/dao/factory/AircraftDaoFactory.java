package org.alexey.bookings.dao.factory;

import org.alexey.bookings.dao.AircraftDao;
import org.alexey.bookings.dao.api.IAircraftDao;

public class AircraftDaoFactory {

    private volatile static AircraftDao instance;

    private AircraftDaoFactory() {
    }

    public static IAircraftDao getInstance() {
        if(instance == null){
            synchronized (AircraftDaoFactory.class){
                if(instance == null){
                    instance = new AircraftDao();
                }
            }
        }
        return instance;
    }
}
