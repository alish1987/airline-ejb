package com.airline.service;

import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
