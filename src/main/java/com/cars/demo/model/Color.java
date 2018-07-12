package com.cars.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {

    @Id
    @GeneratedValue
    Long id;

    String description;


    public Color() {
    }

    public Color(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Color(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
