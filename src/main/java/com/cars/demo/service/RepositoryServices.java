package com.cars.demo.service;


import com.cars.demo.model.*;
import com.cars.demo.repository.*;
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

    @Autowired
    private CountryRepository countryRepository;



    public List<Fuel> getAllFuel(){
        return fuelRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Brand> getAllbrand(){
        return brandRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Gear> getAllgear(){
        return gearRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Country> getAllcountry(){
        return countryRepository.findAll().stream().collect(Collectors.toList());
    }


}
