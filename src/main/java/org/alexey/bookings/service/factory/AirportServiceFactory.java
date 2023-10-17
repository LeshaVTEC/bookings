package org.alexey.bookings.service.factory;

import org.alexey.bookings.dao.factory.AirportDaoFactory;
import org.alexey.bookings.service.AirportService;
import org.alexey.bookings.service.api.IAirportService;

public class AirportServiceFactory {

    private volatile static AirportService instance;

    public AirportServiceFactory() {
    }

    public static IAirportService getInstance(){
        if (instance == null){
            synchronized (AirportServiceFactory.class){
                if (instance == null){
                    instance = new AirportService(AirportDaoFactory.getInstance());
                }
            }
        } return instance;
    }
}
