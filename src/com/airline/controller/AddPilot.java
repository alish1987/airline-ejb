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

@WebServlet("/AddPilot")
public class AddPilot extends HttpServlet {

    @EJB
    PilotService pilotService;

    public AddPilot() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pilot pilot = new Pilot();
        pilot.setFirstName("gary");
        pilot.setLastName("cavana");
        pilot.setPilotRank(PilotRank.Captain);
        pilot.setPilotLicense(32323);
        pilotService.addPilot(pilot);
    }
}
