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
        System.err.println(gear1.getGeartype());
        System.err.println("somthing error");
        Optional<Gear> firstgear = gearRepository.findAll().stream().filter(e -> e.getGeartype().equals(gear1.getGeartype())).findFirst();
        if(firstgear.isPresent())
            return firstgear.get();

        else {
            Gear gear2 = new Gear();
            gear2.setGeartype("NoGear");
            return gear2;
        }

    }

}
