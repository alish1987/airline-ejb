package com.airline.service;

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
public class PilotService {
    @PersistenceContext(unitName = "airline")
    EntityManager entityManager;

    public PilotService() {

    }

    public void addPilot(Pilot pilot) {
        entityManager.persist(pilot);

    }
    public void addNewPilotToFlight(Pilot pilot, String flightId) {
        entityManager.persist(pilot);
        TypedQuery<Flight> query = entityManager.createNamedQuery("flight.findById", Flight.class);
        query.setParameter("id", Integer.valueOf(flightId));
        Flight flight = query.getSingleResult();

        List<Pilot> pilots = flight.getPilots();
        pilots.add(pilot);
        flight.setPilots(pilots);
        pilot.setFlightForPilot(flight);


    }
}
