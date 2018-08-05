package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.model.Fuel;
import com.cars.demo.model.Modell;
import com.cars.demo.model.State;
import com.cars.demo.repository.ColorRepository;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.repository.ModelRepository;
import com.cars.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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

    @GetMapping("getFuel")
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


}
