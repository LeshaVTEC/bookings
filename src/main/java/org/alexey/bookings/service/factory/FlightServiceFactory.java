package org.alexey.bookings.service.factory;

import org.alexey.bookings.dao.factory.FlightDaoFactory;
import org.alexey.bookings.service.FlightService;
import org.alexey.bookings.service.api.IFlightService;

public class FlightServiceFactory {

    private volatile static FlightService instance;

    public FlightServiceFactory() {
    }

    public static IFlightService getInstance(){
        if (instance == null){
            synchronized (FlightServiceFactory.class){
                if (instance == null){
                    instance = new FlightService(FlightDaoFactory.getInstance());
                }
            }
        } return instance;
    }
}
