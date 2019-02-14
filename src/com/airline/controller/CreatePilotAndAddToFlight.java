package com.airline.controller;

import com.airline.models.*;
import com.airline.service.FlightService;
import com.airline.service.PilotService;

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

@WebServlet("/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet {

    @EJB
    PilotService pilotService;

    public CreatePilotAndAddToFlight() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Integer license = Integer.parseInt(request.getParameter("license"));
        String pilotRank = request.getParameter("pilot_rank");
        String flightId = request.getParameter("fId");
        Pilot pilot = new Pilot();
        pilot.setFirstName(firstName);
        pilot.setLastName(lastName);
        pilot.setPilotLicense(license);
        pilot.setPilotRank(PilotRank.valueOf(pilotRank));

        pilotService.addNewPilotToFlight(pilot,flightId);
        response.sendRedirect("Flights");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}