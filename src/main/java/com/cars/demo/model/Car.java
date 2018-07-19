package com.cars.demo.model;

import javax.persistence.*;

@Entity
public class Car {


    @Id
    @GeneratedValue
    Long id;

    private String mileage;
    private String dateOfRegistration;

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

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
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
}
