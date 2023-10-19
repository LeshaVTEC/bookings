package org.alexey.bookings.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.alexey.bookings.dao.api.IFlightDao;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;
import org.alexey.bookings.entity.FlightEntity;

import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {

    private final EntityManagerFactory entityManagerFactory;

    public FlightDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = criteriaBuilder.createQuery(FlightEntity.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightEntity> getFlightsWithFilters(Pageable pageable) {
        return getFlightsWithFilters(null, pageable);
    }

    @Override
    public List<FlightEntity> getFlightsWithFilters(FlightFilter filter, Pageable pageable) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = criteriaBuilder.createQuery(FlightEntity.class);
        Root<FlightEntity> root = query.from(FlightEntity.class);

        Predicate finalPredicate = buildPredicate(filter, criteriaBuilder, root);

        query.where(finalPredicate);

        return entityManager.createQuery(query)
                .setFirstResult(pageable.getPage())
                .setMaxResults(pageable.getSize())
                .getResultList();
    }

    private Predicate buildPredicate(FlightFilter filter, CriteriaBuilder criteriaBuilder, Root<FlightEntity> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getScheduledDeparture() != null) {
            Predicate scheduledDeparturePredicateStart = criteriaBuilder
                    .greaterThan(root.get("scheduled_departure"), filter.getScheduledDeparture());
            Predicate scheduledDeparturePredicateFinish = criteriaBuilder
                    .lessThan(root.get("scheduled_departure"), filter.getScheduledDeparture().plusDays(1));
            predicates.add(scheduledDeparturePredicateStart);
            predicates.add(scheduledDeparturePredicateFinish);
        }
        if (filter.getScheduledArrival() != null) {
            Predicate scheduledArrivalPredicateStart = criteriaBuilder
                    .greaterThan(root.get("scheduled_arrival"), filter.getScheduledArrival());
            Predicate scheduledArrivalPredicateFinish = criteriaBuilder
                    .lessThan(root.get("scheduled_arrival"), filter.getScheduledArrival().plusDays(1));
            predicates.add(scheduledArrivalPredicateStart);
            predicates.add(scheduledArrivalPredicateFinish);
        }
        if (filter.getDepartureAirport() != null) {
            Predicate departureAirportPredicate = criteriaBuilder
                    .equal(root.get("departure_airport"), filter.getDepartureAirport());
            predicates.add(departureAirportPredicate);
        }
        if (filter.getArrivalAirport() != null) {
            Predicate arrivalAirportPredicate = criteriaBuilder
                    .equal(root.get("arrival_airport"), filter.getArrivalAirport());
            predicates.add(arrivalAirportPredicate);
        }
        if (filter.getStatus() != null) {
            Predicate statusPredicate = criteriaBuilder
                    .equal(root.get("status"), filter.getStatus());
            predicates.add(statusPredicate);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
