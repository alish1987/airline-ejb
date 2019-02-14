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

        Passenger passenger = new Passenger();

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);

        String dob_row= request.getParameter("dob");

        String[] dobArr =dob_row.split("\\/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(dobArr[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dobArr[1])-1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobArr[0]));

        Date dob = calendar.getTime();
        passenger.setDob(dob);

        String gender = request.getParameter("gender");
        passenger.setGender(Gender.valueOf(gender));

        passengerService.addPassenger(passenger);
        response.sendRedirect("Passengers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
