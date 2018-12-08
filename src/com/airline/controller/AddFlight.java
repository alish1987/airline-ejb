package com.airline.controller;

import com.airline.models.*;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {

    @EJB
    FlightService flightService;

    public AddFlight() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flight flight = new Flight();
        flight.setFlightOrigins(FlightDestinations.Amesterdom.Los_Angles);
        flight.setFlightDestination(FlightDestinations.Amesterdom.London);
        flight.setProce(400);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        Date flightTime = calendar.getTime();
        flight.setFlightTime(flightTime);
        System.out.println(flightTime);

        Airplane airplane = new Airplane();
        airplane.setModelName("707");
        airplane.setPlaneMake("boeing");
        airplane.setSeatingCapacity(250);

        flight.setAirplaneDetails(airplane);
        System.out.println(flight);
        System.out.println(airplane);

        flightService.addFlight(flight,airplane);
    }
}
