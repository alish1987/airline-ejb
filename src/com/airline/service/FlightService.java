package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public void addPassengerToFlight(String passengerId, String flightId) {
        //passenger
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Passenger> passengerCriteriaQuery = builder.createQuery(Passenger.class);
        Root<Passenger> root = passengerCriteriaQuery.from(Passenger.class);
        passengerCriteriaQuery.select(root).where(builder.equal(root.get("id").as(Integer.class), passengerId));
        TypedQuery<Passenger> passengerTypedQuery = entityManager.createQuery(passengerCriteriaQuery);
        Passenger p = passengerTypedQuery.getSingleResult();
        //flight
        builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> flightCriteriaQuery = builder.createQuery(Flight.class);
        Root<Flight> rootFlight = flightCriteriaQuery.from(Flight.class);
        flightCriteriaQuery.select(rootFlight).where(builder.equal(rootFlight.get("id").as(Integer.class), flightId));
        TypedQuery<Flight> flightTypedQuery = entityManager.createQuery(flightCriteriaQuery);
        Flight f = flightTypedQuery.getSingleResult();
        //Associate Passenger with flight
        List<Passenger> passengers = f.getPassengers();
        passengers.add(p);
        f.setPassengers(passengers);
        p.getFlights().add(f);
    }

    public List<Flight> getFlights() {
        TypedQuery<Flight> flightTypedQuery = entityManager.createQuery("select f from Flight f ", Flight.class);
        List<Flight> flights = flightTypedQuery.getResultList();
        return flights;
    }
}
