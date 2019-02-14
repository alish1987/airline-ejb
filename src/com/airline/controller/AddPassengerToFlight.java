package com.airline.controller;

import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddPassengerToFlight")
public class AddPassengerToFlight extends HttpServlet {

    @EJB
    FlightService flightService;

    public AddPassengerToFlight() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pId = request.getParameter("pId");
        String fId = request.getParameter("fId");
        flightService.addPassengerToFlight(pId,fId);
        response.sendRedirect("Flights");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
