package com.airline.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements Serializable {

    public Flight() {
        super();
    }

    //هر پرواز یک هواپیما دارد و هر هواپیما هم یک پرواز دارد رابطه بین انتیتی flight و airplane
    private static final long serialVersionUID = -4526086093063388797L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightOrigins;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightDestination;

    private Integer proce;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    @OneToOne
    @JoinColumn(name = "airplane_fk")
    private Airplane airplaneDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FlightDestinations getFlightOrigins() {
        return flightOrigins;
    }

    public void setFlightOrigins(FlightDestinations flightOrigins) {
        this.flightOrigins = flightOrigins;
    }

    public FlightDestinations getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(FlightDestinations flightDestination) {
        this.flightDestination = flightDestination;
    }

    public Integer getProce() {
        return proce;
    }

    public void setProce(Integer proce) {
        this.proce = proce;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public Airplane getAirplaneDetails() {
        return airplaneDetails;
    }

    public void setAirplaneDetails(Airplane airplaneDetails) {
        this.airplaneDetails = airplaneDetails;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightOrigins=" + flightOrigins +
                ", flightDestination=" + flightDestination +
                ", proce=" + proce +
                ", flightTime=" + flightTime +
                '}';
    }
}
