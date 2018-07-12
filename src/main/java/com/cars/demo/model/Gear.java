package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gear {

    @Id
    @GeneratedValue
    private Long id;
    private String geartype;

    public Gear() {
    }

    public Gear(String geartype) {
        this.id = id;
        this.geartype = geartype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeartype() {
        return geartype;
    }

    public void setGeartype(String geartype) {
        this.geartype = geartype;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "id=" + id +
                ", geartype='" + geartype + '\'' +
                '}';
    }
}
