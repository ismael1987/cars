package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {


    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    Color color;

    @OneToOne
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
                ", color=" + color +
                ", gear=" + gear +
                '}';
    }
}
