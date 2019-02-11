package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class FlightService {

    public FlightService() {
    }

    @PersistenceContext(name = "airline")
    EntityManager entityManager;


    public void addFlight(Flight flight) {
        entityManager.persist(flight);

    }

    public void addPilotToFlight(String pilotId, String flightId) {
        TypedQuery<Flight> query = entityManager.createNamedQuery("flight.findById", Flight.class);
        query.setParameter("id", Integer.valueOf(flightId));
        Flight flight = query.getSingleResult();

        TypedQuery<Pilot> pilotTypedQuery = entityManager.createNamedQuery("pilot.findById", Pilot.class);
        pilotTypedQuery.setParameter("id", Integer.valueOf(pilotId));
        Pilot pilot = pilotTypedQuery.getSingleResult();

        List<Pilot> pilots = flight.getPilots();
        pilots.add(pilot);
        flight.setPilots(pilots);
        pilot.setFlightForPilot(flight);

    }

    public List<Flight> getFlights() {
        TypedQuery<Flight> flightTypedQuery = entityManager.createQuery("select f from Flight f ", Flight.class);
        List<Flight> flights = flightTypedQuery.getResultList();
        return flights;
    }
}
