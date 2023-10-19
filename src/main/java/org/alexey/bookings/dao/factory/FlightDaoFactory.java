package org.alexey.bookings.dao.factory;

import org.alexey.bookings.dao.FlightDao;
import org.alexey.bookings.dao.api.IFlightDao;

public class FlightDaoFactory {

    private volatile static FlightDao instance;

    public FlightDaoFactory() {
    }

    public static IFlightDao getInstance() {
        if (instance == null) {
            synchronized (FlightDaoFactory.class){
                if (instance == null){
                    instance = new FlightDao(EntityManagerFactoryFactory.getInstance());
                }
            }
        } return instance;
    }
}
