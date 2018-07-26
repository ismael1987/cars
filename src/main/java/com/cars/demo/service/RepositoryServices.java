package com.cars.demo.service;


import com.cars.demo.model.Fuel;
import com.cars.demo.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositoryServices {

    @Autowired
    private  FuelRepository fuelRepository;


    public List<Fuel> getAllFuel(){
        return fuelRepository.findAll().stream().collect(Collectors.toList());
    }

}
