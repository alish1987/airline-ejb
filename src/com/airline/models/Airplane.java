package com.airline.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Airplane implements Serializable {
    //هر پرواز یک هواپیما دارد و هر هواپیما هم یک پرواز دارد رابطه بین انتیتی flight و airplane

    private static final long serialVersionUID = 5568028506178931985L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String planeMake;
    private String modelName;
    private Integer seatingCapacity;
    @OneToOne(mappedBy = "airplaneDetails")
    private Flight flight;

    public Airplane() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaneMake() {
        return planeMake;
    }

    public void setPlaneMake(String planeMake) {
        this.planeMake = planeMake;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", planeMake='" + planeMake + '\'' +
                ", modelName='" + modelName + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
