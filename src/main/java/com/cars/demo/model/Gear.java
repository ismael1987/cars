package com.cars.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Gear {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false ,  unique = true)
    @Size(min=1 , max=255)
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
