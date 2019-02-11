package com.airline.controller;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

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

@WebServlet("/Passengers")
public class Passengers extends HttpServlet {

    @EJB
    PassengerService passengerService;

    public Passengers() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Passenger> passengers = passengerService.getPassengers();
        request.setAttribute("passenger_list", passengers);
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/passenger_list.jsp");
        dispatcher.forward(request, response);
        out.println("List of Passengers is This Here ....");

    }
}
