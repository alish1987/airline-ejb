package com.airline.rest;

import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/flights")
public class FlightWebservice {

    @PersistenceContext(unitName = "airline")
    EntityManager entityManager;

    @EJB
    FlightService flightService;

    @Context
    UriInfo uriInfo;

    public FlightWebservice() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{flight_id}")
    public Flight getFlight(@PathParam("flight_id") Integer flightId) {
        Flight flight = flightService.getFlight(flightId);
        if (flight == null)
            throw new NotFoundException("The Flight With an Id of " + flightId + " wWas Not Found.");
        return flight;
    }


    @DELETE
    @Path("{flight_id}")
    public Response deleteFlight(@PathParam("flight_id") Integer flightId) {
        Flight flightToRemove = entityManager.find(Flight.class, flightId);
        if (flightToRemove == null)
            throw new NotFoundException("The Flight With an Id of " + flightId + " wWas Not Found.");

        entityManager.remove(flightToRemove);
        return Response.noContent().build();
    }

}
