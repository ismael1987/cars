package com.cars.demo.service;


import com.cars.demo.model.Brand;
import com.cars.demo.model.Fuel;
import com.cars.demo.model.Gear;
import com.cars.demo.repository.BrandRepository;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositoryServices {

    @Autowired
    private  FuelRepository fuelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private GearRepository gearRepository;

    public List<Fuel> getAllFuel(){
        return fuelRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Brand> getAllbrand(){
        return brandRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Gear> getAllgear(){
        return gearRepository.findAll().stream().collect(Collectors.toList());
    }

}
