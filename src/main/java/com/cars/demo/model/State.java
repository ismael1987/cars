package com.cars.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class State {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false ,  unique = true)
    @NotBlank
    private String stateName;

    @ManyToOne
    private Country country;


    public State() {
    }

    public State(String stateName, Country country) {
        this.stateName = stateName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                '}';
    }
}
