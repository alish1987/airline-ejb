package com.airline.controller;

import com.airline.service.FlightService;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddFlightTicketToPassenger")
public class AddFlightTicketToPassenger extends HttpServlet {

    @EJB
    PassengerService passengerService;

    public AddFlightTicketToPassenger() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pId = request.getParameter("pId");
        String fId = request.getParameter("fId");
        passengerService.addFlightTicketToPassenger(pId,fId);
        response.sendRedirect("Passengers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
