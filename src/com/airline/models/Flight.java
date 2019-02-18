package com.airline.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQuery(name = "flight.findById", query = "select f from Flight f where f.id = :id")
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

    private Integer price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    // پرواز می تواند چندیدن مسافر داشته باشد و مسافران هم می توانند چند بلیط پرواز داشته باشند پس رابطه چند به چند دارند .
    @JoinTable(name = "f_p_join", joinColumns = @JoinColumn(name = "flight_fk"), inverseJoinColumns = @JoinColumn(name = "passenger_fk"))
    private List<Passenger> passengers;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "airplane_fk")
    private Airplane airplaneDetails;

    @OneToMany(mappedBy = "flightForPilot",cascade = {CascadeType.REMOVE})
    private List<Pilot> pilots;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer proce) {
        this.price = proce;
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

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightOrigins=" + flightOrigins +
                ", flightDestination=" + flightDestination +
                ", proce=" + price +
                ", flightTime=" + flightTime +
                ", airplaneDetails=" + airplaneDetails +
                ", pilots=" + pilots +
                '}';
    }
}
