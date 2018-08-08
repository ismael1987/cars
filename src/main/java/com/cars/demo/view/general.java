package com.cars.demo.view;

import com.cars.demo.model.*;
import com.cars.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class general {

    @Autowired
    StateRepository stateRepository;
    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    FuelRepository fuelRepository;

    @Autowired
    GearRepository gearRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("getState")
   List<State> getState(@Valid Long country){

        return stateRepository.findAll().stream().filter(state -> state.getCountry().getId().equals(country)).collect(Collectors.toList()) ;
    }

    @GetMapping("getmodel")
    List<Modell> getmodel(@Valid Long brand){
        return  modelRepository.findAll().stream().filter(modell -> modell.getBrand().getId().equals(brand)).collect(Collectors.toList());
    }

    @GetMapping("getColor")
    Color  getColor(@Valid Color colorName){
        System.err.println(colorName.getDescription());
        System.err.println("something error");
        Optional<Color> firstColor = colorRepository.findAll().stream().filter(color -> color.getDescription().equals(colorName.getDescription())).findFirst();
        if (firstColor.isPresent())
                return firstColor.get();
        else {
            Color color = new Color();
            color.setDescription("NoColor");
            return  color;
        }

    }

    @GetMapping("/getFuel")
    Fuel getFuel(@Valid Fuel fuel){
        System.err.println(fuel.getFueltype());
        System.err.println("somthing error");
        Optional<Fuel> firstFuel = fuelRepository.findAll().stream().filter(e -> e.getFueltype().equals(fuel.getFueltype())).findFirst();
        if (firstFuel.isPresent())
            return firstFuel.get();
        else {
            Fuel fuel2 = new Fuel();
            fuel2.setFueltype("NoFuel");
            return fuel2;
        }
    }

    @GetMapping("/getGear")
    Gear getGear(@Valid Gear gear1){
        Optional<Gear> firstGear = gearRepository.findAll().stream().filter(e -> e.getGeartype().equals(gear1.getGeartype())).findFirst();
        if(firstGear.isPresent()) {
            System.err.println("Here");
            return firstGear.get();
        }
        else {
            Gear gear2 = new Gear();
            gear2.setGeartype("NoGear");
            return gear2;
        }

    }

    @GetMapping("/getBrand")
    Brand getBrand(@Valid Brand brand1){
        System.err.println(brand1.getBrandName());
        System.err.println("somthing error");
        Optional<Brand> firstBrand = brandRepository.findAll().stream().filter(e ->e.getBrandName().equals(brand1.getBrandName())).findFirst();

        if(firstBrand.isPresent())
            return firstBrand.get();
        else {
            Brand brand2 = new Brand();
            brand2.setBrandName("NoBrand");
            return brand2;
        }
    }

    @GetMapping("/getCountry")
    Country getCountry(@Valid Country country1){
       System.err.println(country1.getCountryName());
       System.err.println("somthing error");
       Optional<Country> firstCountry = countryRepository.findAll().stream().filter(e ->e.getCountryName().equals(country1.getCountryName())).findFirst();

       if(firstCountry.isPresent())
           return firstCountry.get();
       else {
           Country country2 = new Country();
           country2.setCountryName("NoCountry");
           return country2;
       }
    }

    @GetMapping("/checkState")
    State checkState(@Valid String  stateName , @Valid String countryNo) {
        System.err.println(stateName);
        System.err.println(countryNo);

        Optional<State> firstState = stateRepository.findAll().stream()
                .filter(e -> e.getStateName().equalsIgnoreCase(stateName))
                .filter(e -> e.getCountry().getId().equals(Long.parseLong(countryNo)))
                .findFirst();
        if (firstState.isPresent())
        {
            State state = new State();
            state.setStateName("Found");
            return state;
        }
        else {
            State state = new State();
            state.setStateName("notFound");
            return state;
        }

    }
}