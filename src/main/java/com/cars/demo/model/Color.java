package com.cars.demo.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Color {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @Column(nullable = false ,  unique = true)
    @Size(min=1 , max=255)
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
