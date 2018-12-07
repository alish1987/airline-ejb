package com.airline.controller;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {

    @EJB
    PassengerService passengerService;

    public AddPassenger() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger passenger = new Passenger();
        passenger.setFirstName("alish");
        passenger.setLastName("gholian");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1988);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 3);
        Date dob = calendar.getTime();
        passenger.setDob(dob);
        passenger.setGender(Gender.FEMALE);
        passenger.setFlightClass(FlightClass.BUSINESS);
        System.out.println(passenger);
        passengerService.addPassenger(passenger);
    }
}
