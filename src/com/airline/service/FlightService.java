package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class FlightService {

    public FlightService() {
    }

    @PersistenceContext(name = "airline")
    EntityManager entityManager;


    public void addFlight(Flight flight, Airplane airplane) {
        entityManager.persist(flight);
        entityManager.persist(airplane);

    }
}
