package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Modell {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @NotNull
    private String modelNumber;

    @ManyToOne
    private Brand brand;

    public Modell() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Modell{" +
                "id=" + id +
                ", modelNumber='" + modelNumber + '\'' +
                ", brand=" + brand +
                '}';
    }
}
