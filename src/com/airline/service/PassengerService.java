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
    public void addFlightTicketToPassenger(String passengerId, String flightId) {
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
        //Associate flight  with Passenger
        List<Flight> flights = p.getFlights();
        flights.add(f);
        p.setFlights(flights);
        f.getPassengers().add(p);
    }
}
