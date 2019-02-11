package com.airline.controller;

import com.airline.models.Flight;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Flights")
public class Flights extends HttpServlet {

    @EJB
    FlightService flightService;

    public Flights() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = flightService.getFlights();
        request.setAttribute("flight_list", flights);
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/flight_list.jsp");
        dispatcher.forward(request,response);
        out.println("List of Flights is This Here ....");

    }
}
