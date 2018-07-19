package com.cars.demo.view;

import com.cars.demo.model.Modell;
import com.cars.demo.model.State;
import com.cars.demo.repository.ModelRepository;
import com.cars.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class general {

    @Autowired
    StateRepository stateRepository;
    @Autowired
    ModelRepository modelRepository;

    @GetMapping("getState")
    List<State> getState(@Valid Long country){

        return stateRepository.findAll().stream().filter(state -> state.getCountry().getId().equals(country)).collect(Collectors.toList()) ;
    }

    @GetMapping("getmodel")
    List<Modell> getmodel(@Valid Long brand){
        return  modelRepository.findAll().stream().filter(modell -> modell.getBrand().getId().equals(brand)).collect(Collectors.toList());
    }

}
