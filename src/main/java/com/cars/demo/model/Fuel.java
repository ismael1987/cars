package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fuel {
    @Id
    @GeneratedValue
    private Long id;
    private String fueltype;

    public Fuel() {
    }

    public Fuel(Long id, String feultype) {
        this.id = id;
        this.fueltype = feultype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeultype() {
        return fueltype;
    }

    public void setFeultype(String feultype) {
        this.fueltype = feultype;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "id=" + id +
                ", feultype='" + fueltype + '\'' +
                '}';
    }
}
