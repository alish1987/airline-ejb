package com.airline.rest;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/passengers")
public class PassengerWebservice {

    @PersistenceContext(unitName = "airline")
    EntityManager entityManager;

    @EJB
    PassengerService passengerService;

    @Context
    UriInfo uriInfo;

    public PassengerWebservice() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Passenger> getPassengers() {

        List<Passenger> passengers = passengerService.getPassengers();
        return passengers;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{passenger_id}")
    public Passenger getPassenger(@PathParam("passenger_id") Integer passengerId) {

        Passenger passenger = passengerService.getPassenger(passengerId);
        if (passenger == null)
            throw new NotFoundException("The Passenger With an Id of " + passengerId + " Was Not Found.");
        return passenger;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPassenger(Passenger passenger) {
        passenger = passengerService.addPassenger(passenger);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        URI uri = uriBuilder.path(String.valueOf(passenger.getId())).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("/edit/{pId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassenger(@PathParam("pId") Integer pId, Passenger pUpdate) {
        pUpdate = passengerService.updatePassenger(pId, pUpdate);
        if (pUpdate == null)
            throw new NotFoundException("The Passenger With an Id of " + pId + " Was Not Found.");
        return Response.ok(pUpdate).build();
    }

    @PUT
    @Path("/edit2/{pId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassenger2(@PathParam("pId") Integer pId, Passenger pUpdate) {
        pUpdate = passengerService.updatePassenger2(pId, pUpdate);
        if (pUpdate == null)
            throw new NotFoundException("The Passenger With an Id of " + pId + " Was Not Found.");
        return Response.ok(pUpdate).build();
    }


}
