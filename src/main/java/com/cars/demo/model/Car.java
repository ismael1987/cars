package com.cars.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Car {


    @Id
    @GeneratedValue
    Long id;

    private Long mileage;

    private Date dateOfRegistration;

    private Integer numberOfSeats;

    private Long power;

    private Integer numberOfDoors;

    private Long price;

    @Lob
    private byte[] image;

    @ManyToOne
    Modell modell;

    @ManyToOne
    Brand brand;

    @ManyToOne
    Color color;
    @ManyToOne
    Gear gear;
    @ManyToOne
    Country country;
    @ManyToOne
    State state;
    @ManyToOne
    Fuel fuel;


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

    public Modell getModell() {
        return modell;
    }

    public void setModell(Modell modell) {
        this.modell = modell;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", dateOfRegistration=" + dateOfRegistration +
                ", numberOfSeats=" + numberOfSeats +
                ", power=" + power +
                ", numberOfDoors=" + numberOfDoors +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                ", modell=" + modell +
                ", brand=" + brand +
                ", color=" + color +
                ", gear=" + gear +
                ", country=" + country +
                ", state=" + state +
                ", fuel=" + fuel +
                '}';
    }
}
