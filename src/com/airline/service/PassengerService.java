package com.airline.service;

import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class PassengerService {
    public PassengerService() {
    }

    @PersistenceContext(unitName = "airline")
    private EntityManager entityManager;

    public void addPassenger(Passenger passenger) {
        entityManager.persist(passenger);
    }

    public List<Passenger> getPassengers() {
        TypedQuery<Passenger> passengerTypedQuery = entityManager.createQuery("select p from Passenger p ", Passenger.class);
        List<Passenger> passengers = passengerTypedQuery.getResultList();
        return passengers;
    }
}
