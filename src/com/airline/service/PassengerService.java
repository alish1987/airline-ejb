package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public Passenger addPassenger(Passenger passenger) {
         entityManager.persist(passenger);
        return passenger;
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

    public Passenger getPassenger(Integer passengerId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Passenger> passengerCriteriaQuery = builder.createQuery(Passenger.class);
        Root<Passenger> root = passengerCriteriaQuery.from(Passenger.class);
        passengerCriteriaQuery.select(root).where(builder.equal(root.get("id").as(Integer.class), passengerId));
        TypedQuery<Passenger> passengerTypedQuery = entityManager.createQuery(passengerCriteriaQuery);
        Passenger passenger = new Passenger();
        try {
            passenger = passengerTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return passenger;
    }

    public Passenger updatePassenger(Integer passId, Passenger passenger) {
        Passenger p = entityManager.find(Passenger.class, passId);
        if (p == null) {
            return null;
        }
        if (passenger.getFirstName() != null) {
            p.setFirstName(passenger.getFirstName());
        }
        if (passenger.getLastName() != null) {
            p.setLastName(passenger.getLastName());
        }
        if (passenger.getDob() != null) {
            p.setDob(passenger.getDob());
        }
        if (passenger.getGender() != null) {
            p.setGender(passenger.getGender());
        }
        return p;
    }
    public Passenger updatePassenger2(Integer passId, Passenger passenger) {
        passenger.setId(passId);
        Passenger checkExist= entityManager.find(Passenger.class, passId);
        if (checkExist==null)
            return null;
        entityManager.merge(passenger);
        return passenger;

    }
}
