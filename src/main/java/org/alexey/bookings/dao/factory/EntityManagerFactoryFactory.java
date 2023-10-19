package org.alexey.bookings.dao.factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryFactory {
    private final static EntityManagerFactory instance;

    static {
        instance = Persistence.createEntityManagerFactory("booking");
    }

    public static EntityManagerFactory getInstance() {
        return instance;
    }
}
