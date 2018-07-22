package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeOfCar {

    @Id
    @GeneratedValue
    private Long id;
    private String carType;

    public TypeOfCar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "TypeOfCar{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                '}';
    }
}
