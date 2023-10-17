package org.alexey.bookings.dao.factory;

import org.alexey.bookings.dao.AirportDao;
import org.alexey.bookings.dao.api.IAirportDao;

public class AirportDaoFactory {

    private volatile static AirportDao instance;

    public AirportDaoFactory() {
    }

    public static IAirportDao getInstance(){
        if (instance == null) {
            synchronized (AirportDaoFactory.class){
                if (instance == null) {
                    instance = new AirportDao();
                }
            }
        } return instance;
    }
}
