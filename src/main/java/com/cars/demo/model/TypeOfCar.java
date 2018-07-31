package com.cars.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TypeOfCar {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false ,  unique = true)
    @Size(min=1 , max=255)
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
