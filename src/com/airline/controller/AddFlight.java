package com.airline.controller;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
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
import java.util.Objects;

@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {

    @EJB
    FlightService flightService;

    public AddFlight() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flight flight = new Flight();
        String fromDestination = request.getParameter("form_destination");
        flight.setFlightOrigins(FlightDestinations.valueOf(fromDestination));
        String toDestination = request.getParameter("to_destination");
        flight.setFlightDestination(FlightDestinations.valueOf(toDestination));
        String price = request.getParameter("price");
        if (Objects.nonNull(price))
            flight.setPrice(Integer.valueOf(price));

        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer hour = Integer.parseInt(request.getParameter("hour"));
        Integer minute = Integer.parseInt(request.getParameter("minute"));

        flight.setFlightOrigins(FlightDestinations.Amesterdom.Los_Angles);
        flight.setPrice(400);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        Date flightTime = calendar.getTime();
        flight.setFlightTime(flightTime);
        System.out.println(flightTime);

        Airplane airplane = new Airplane();
        String modelName = request.getParameter("model_name");
        airplane.setModelName(modelName);
        String planeMake = request.getParameter("airPlane_make");
        airplane.setPlaneMake(planeMake);
        Integer seating = Integer.parseInt(request.getParameter("seating"));
        airplane.setSeatingCapacity(seating);

        flight.setAirplaneDetails(airplane);
        System.out.println(flight);
        System.out.println(airplane);

        flightService.addFlight(flight);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}