package org.alexey.bookings.service.factory;

import org.alexey.bookings.dao.factory.AircraftDaoFactory;
import org.alexey.bookings.service.AircraftService;
import org.alexey.bookings.service.api.IAircraftService;

public class AircraftServiceFactory {

    private volatile static AircraftService instance;

    public AircraftServiceFactory() {
    }

    public static IAircraftService getInstance(){
        if (instance == null){
            synchronized (AircraftServiceFactory.class){
                if (instance == null){
                    instance = new AircraftService(AircraftDaoFactory.getInstance());
                }
            }
        } return instance;
    }
}
