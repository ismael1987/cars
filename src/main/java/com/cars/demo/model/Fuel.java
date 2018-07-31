package com.cars.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fuel {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false ,  unique = true)
    @Size(min=1 , max=255)
    private String fueltype;

    public Fuel() {
    }

    public Fuel(String fueltype) {
        this.id = id;
        this.fueltype = fueltype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "id=" + id +
                ", fueltype='" + fueltype + '\'' +
                '}';
    }
}
