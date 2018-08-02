package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.model.Fuel;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.service.RepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FuelView {

    @Autowired
    private  FuelRepository fuelRepository;


    @Autowired
    private RepositoryServices repositoryServices;


    @ModelAttribute("fuels")
    public List<Fuel> getFuels(){
        List<Fuel> collectFuel = repositoryServices.getAllFuel();
        return collectFuel;
    }


    @GetMapping("/fuel" )
    public String getfuel(){
        
        return "fuel";
    }




    @PostMapping("/fuel")
    public String addfuel(@Valid String fuel){
        long count = fuelRepository.findAll().stream().filter(e -> e.getFueltype().equalsIgnoreCase(fuel)).count();
        if(count == 0L){
            Fuel newfuel = new Fuel(fuel);
            fuelRepository.save(newfuel);
        }
        return "redirect:fuel";    }
}
