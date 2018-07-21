package com.cars.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Car {


    @Id
    @GeneratedValue
    Long id;

    private Long mileage;
    private Date dateOfRegistration;

    @ManyToOne
    Color color;

    @ManyToOne
    Gear gear;


    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mileage='" + mileage + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", color=" + color +
                ", gear=" + gear +
                '}';
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
